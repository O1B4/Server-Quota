package com.o1b4.serverquota.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
    @Id
    private Long teamId;

    @Column(name = "teamName", length = 100, nullable = false)
    private String teamName;

    @Column(name = "teamProfileImage")
    private String teamProfileImage;

    @Column(name = "teamUrl", length = 20, nullable = false)
    private String teamUrl;

    @Column(name = "teamDescription", length = 255)
    private String teamDescription;
}