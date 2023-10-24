package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.TeamDTO;
import com.o1b4.serverquota.entity.Team;
import com.o1b4.serverquota.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    private final ModelMapper modelMapper;

    public TeamService(TeamRepository teamRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }

    public TeamDTO findTeamByUserId(long userId) {
        Team team = teamRepository.findTeamByUserId(userId);

        // 조회 결과 없을 시 빈 teamDTO 반환
        if (team == null) {
            return new TeamDTO();
        }
        return  modelMapper.map(team, TeamDTO.class);
    }

}
