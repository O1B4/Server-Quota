package com.o1b4.serverquota.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "team")
public class Team {
    @Id
    @Column(name = "teamid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @Column(name = "teamname", length = 100, nullable = false)
    private String teamName;

    @Column(name = "teamprofileimage")
    private String teamProfileImage;

    @Column(name = "teamurl", length = 20, nullable = false)
    private String teamUrl;

    @Column(name = "teamdescription", length = 255)
    private String teamDescription;

    @OneToMany(mappedBy = "teamId")
    private List<BelongTeam> belongTeams;

    @Builder
    public Team(Long teamId, String teamName, String teamProfileImage, String teamUrl, String teamDescription, List<BelongTeam> belongTeams) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamProfileImage = teamProfileImage;
        this.teamUrl = teamUrl;
        this.teamDescription = teamDescription;
        this.belongTeams = belongTeams;
    }
}