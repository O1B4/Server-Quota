package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "useremail", length = 100, nullable = false)
    private String userEmail;

    @Column(name = "username", length = 100, nullable = false)
    private String userName;

    @Column(name = "userprofileimage")
    private String userProfileImage;

    @OneToMany
    @JoinColumn(name = "userid")
    private List<BelongTeam> belongTeams;
    public User() {
    }

    public User(Long userId, String userEmail, String userName, String userProfileImage) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }
}