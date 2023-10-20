package com.o1b4.serverquota.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "userEmail", length = 100, nullable = false)
    private String userEmail;

    @Column(name = "userName", length = 100, nullable = false)
    private String userName;

    @Column(name = "userProfileImage")
    private String userProfileImage;
}