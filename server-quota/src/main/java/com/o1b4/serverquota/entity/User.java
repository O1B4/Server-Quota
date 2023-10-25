package com.o1b4.serverquota.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "useremail", length = 100, nullable = false)
    private String userEmail;

    @Column(name = "username", length = 100, nullable = false)
    private String userName;

    @Column(name = "userprofileimage")
    private String userProfileImage;

    @OneToMany(mappedBy = "userId")
    private List<BelongTeam> belongTeams;

}