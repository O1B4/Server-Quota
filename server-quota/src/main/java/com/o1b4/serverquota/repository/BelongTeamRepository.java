package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.BelongTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BelongTeamRepository extends JpaRepository<BelongTeam, Long> {

    // userId로 소속되어 있는 팀 찾기
    Optional<BelongTeam> findFirstByUserId(long userId);

    List<BelongTeam> findByTeamId(long teamId);

    List<BelongTeam> findByUserId(long userId);

    Optional<BelongTeam> findBelongTeamByTeamIdAndUserId(long teamId, long userId);
}
