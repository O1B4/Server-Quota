package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // teamId에 속한 Team 하나만 조회 쿼리문
    Team findFirstByTeamId(@Param("teamid") long teamId);

    Optional<Team> findTeamByTeamId(Long teamId);

    Boolean existsByTeamUrl(String url);
}
