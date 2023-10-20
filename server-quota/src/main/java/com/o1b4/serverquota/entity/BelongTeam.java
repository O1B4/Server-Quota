package com.o1b4.serverquota.entity;

import javax.persistence.*;

enum UserRole {
    ADMIN,
    ADVISOR,
    MEMBER
}

@Entity
@Table(name = "belongTeam")
public class BelongTeam {
    @Id
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team team;

    @Enumerated(EnumType.STRING)
    @Column(name = "userRole", length = 20, nullable = false)
    private UserRole userRole = UserRole.ADMIN;
}