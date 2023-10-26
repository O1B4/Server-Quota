package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.response.MainTeamDTO;
import com.o1b4.serverquota.dto.response.TeamMemberDTO;
import com.o1b4.serverquota.entity.BelongTeam;
import com.o1b4.serverquota.entity.Team;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.repository.BelongTeamRepository;
import com.o1b4.serverquota.repository.TeamRepository;
import com.o1b4.serverquota.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final BelongTeamRepository belongTeamRepository;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository, BelongTeamRepository belongTeamRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.belongTeamRepository = belongTeamRepository;
    }

    public MainTeamDTO findTeamByUserId(long userId) {

        // 해당 user의 첫 번째 소속팀의 Team
        BelongTeam belongTeam = belongTeamRepository.findFirstByUserId(userId)
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "소속된 팀이 없습니다."));

        Team team = teamRepository.findFirstByTeamId(belongTeam.getTeamId());

        return MainTeamDTO.builder()
                .teamProfileImage(team.getTeamProfileImage())
                .teamName(team.getTeamName())
                .teamUrl(team.getTeamUrl())
                .role(String.valueOf(belongTeam.getUserRole()))
                .build();
    }

    public List<TeamMemberDTO> findTeamMembersByTeamId(long teamId) {

        // teamId를 받아 belongTeam 매핑 테이블 조회
        List<BelongTeam> belongTeams = belongTeamRepository.findByTeamId(teamId);

        // list에 해당하는 room들 DTO 매핑
        return belongTeams.stream()
                .map(
                        belongTeam -> TeamMemberDTO.builder()
                        .userName(
                                userRepository.findUserByUserId(belongTeam.getUserId())
                                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "회원을 조회할 수 없습니다."))
                                .getUserName()
                        )
                        .userProfileImage(
                                userRepository.findUserByUserId(belongTeam.getUserId())
                                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "회원을 조회할 수 없습니다."))
                                .getUserProfileImage()
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }
}
