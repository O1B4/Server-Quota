package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.response.MainTeamDTO;
import com.o1b4.serverquota.dto.response.RolelessMainTeamDTO;
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

    public List<String> findTeamsByUserId(long userId) {

        List<BelongTeam> belongTeams = belongTeamRepository.findByUserId(userId);

        // userID에 해당하는 Team의 id list
        List<Long> teamIdList = belongTeams.stream()
                .map(BelongTeam::getTeamId)
                .collect(Collectors.toList());

        // 팀 이름 리스트
        return teamIdList.stream()
                .map(
                        teamId -> teamRepository.findTeamByTeamId(teamId)
                                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "해당 팀을 찾지 못했습니다."))
                                .getTeamName()
                )
                .collect(Collectors.toList());
    }

    public boolean checkIfUrlIsUsable(String url) {

        return !teamRepository.existsByTeamUrl(url);
    }

    public RolelessMainTeamDTO findTeamByTeamId(long teamId) {

        Team team = teamRepository.findTeamByTeamId(teamId)
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "해당 팀은 조회되지 않습니다."));

        return RolelessMainTeamDTO.builder()
                .teamName(team.getTeamName())
                .teamProfileImage(team.getTeamProfileImage())
                .teamUrl(team.getTeamUrl())
                .build();
    }

    public String findTeamUrl(long teamId) {
        Team team = teamRepository.findTeamByTeamId(teamId)
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "해당 팀은 조회되지 않습니다."));

        return team.getTeamUrl();
    }
}
