package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column(name = "teamid")
    private Long teamId;

    @Column(name = "teamname", length = 100, nullable = false)
    private String teamName;

    @Column(name = "teamprofileimage")
    private String teamProfileImage;

    @Column(name = "teamurl", length = 20, nullable = false)
    private String teamUrl;

    @Column(name = "teamdescription", length = 255)
    private String teamDescription;

    public Team(Long teamId, String teamName, String teamProfileImage, String teamUrl, String teamDescription) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamProfileImage = teamProfileImage;
        this.teamUrl = teamUrl;
        this.teamDescription = teamDescription;
    }
}