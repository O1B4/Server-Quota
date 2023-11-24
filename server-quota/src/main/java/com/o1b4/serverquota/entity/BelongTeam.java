package com.o1b4.serverquota.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@IdClass(BelongTeamId.class)
@Table(name = "belongteam")
public class BelongTeam implements Serializable{

    @Id
    @Column(name = "userid")
    private Long userId;

    @Id
    @Column(name = "teamid")
    private Long teamId;

    @Enumerated(EnumType.STRING)
    @Column(name = "userrole", length = 20, nullable = false)
    private  UserRole userRole;

    @Builder
    public BelongTeam(Long userId, Long teamId, UserRole userRole) {
        this.userId = userId;
        this.teamId = teamId;
        this.userRole = userRole;
    }
}

