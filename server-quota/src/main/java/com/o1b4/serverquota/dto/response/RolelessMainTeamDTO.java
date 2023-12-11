package com.o1b4.serverquota.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RolelessMainTeamDTO {

    // main page의 이름, 프로필 사진, url, teamID
    private Long teamId;

    private String teamName;

    private String teamProfileImage;

    private String teamUrl;

    @Builder
    public RolelessMainTeamDTO(Long teamId, String teamName, String teamProfileImage, String teamUrl) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamProfileImage = teamProfileImage;
        this.teamUrl = teamUrl;
    }
}
