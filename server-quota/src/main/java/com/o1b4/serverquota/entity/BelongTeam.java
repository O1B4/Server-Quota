package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

enum UserRole {
    ADMIN,
    ADVISOR,
    MEMBER
}

@Entity
@Getter
@ToString
@Table(name = "belongteam")
public class BelongTeam implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "teamid", nullable = false)
    private Team team;

    @Enumerated(EnumType.STRING)
    @Column(name = "userrole", length = 20, nullable = false)
    private UserRole userRole = UserRole.ADMIN;

    public BelongTeam() {
    }

    public BelongTeam(User user, Team team, UserRole userRole) {
        this.user = user;
        this.team = team;
        this.userRole = userRole;
    }
}