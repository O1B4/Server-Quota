package com.o1b4.serverquota.entity;

import com.o1b4.serverquota.dto.UserDTO;

import lombok.*;

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
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "useremail", length = 100)
    private String userEmail;

    @Column(name = "username", length = 100)
    private String userName;

    @Column(name = "userprofileimage")
    private String userProfileImage;

    @OneToMany(mappedBy = "userId")
    private List<BelongTeam> belongTeams;

    public User(UserDTO userDTO) {
        this.userEmail = userDTO.getUserEmail();
        this.userName = userDTO.getUserName();
        this.userProfileImage = userDTO.getUserProfileImage();
    }
    @Builder
    public User(String userEmail, String userName, String userProfileImage) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }

    public void ChangeUserInfo(String userEmail, String userName, String userProfileImage) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }
}