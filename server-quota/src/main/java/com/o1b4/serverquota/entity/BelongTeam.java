package com.o1b4.serverquota.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

enum UserRole {
    ADMIN,
    ADVISOR,
    MEMBER
}

@Entity
@Getter
@AllArgsConstructor
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
    private UserRole userRole = UserRole.ADMIN;

}

