package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.response.MainTeamDTO;
import com.o1b4.serverquota.entity.BelongTeam;
import com.o1b4.serverquota.entity.Team;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.repository.BelongTeamRepository;
import com.o1b4.serverquota.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    private final BelongTeamRepository belongTeamRepository;

    public TeamService(TeamRepository teamRepository, BelongTeamRepository belongTeamRepository) {
        this.teamRepository = teamRepository;
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
}
