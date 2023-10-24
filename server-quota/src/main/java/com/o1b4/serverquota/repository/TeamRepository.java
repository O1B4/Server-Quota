package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // userId로 속한 Team 하나만 조회 쿼리문
    @Query(value = "SELECT t.teamId, t.teamname, t.teamprofileimage, t.teamurl, t.teamdescription " +
            "FROM team t " +
            "JOIN belongteam b, user u " +
            "WHERE t.teamid = b.teamid and u.userid = b.userid " +
            "and u.userid = ?1 LIMIT 1", nativeQuery = true)
    Team findTeamByUserId(@Param("userId") long userId);
}
