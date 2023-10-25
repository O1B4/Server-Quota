package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // teamId에 속한 Team 하나만 조회 쿼리문
    Team findFirstByTeamId(@Param("teamid") long teamId);
}
