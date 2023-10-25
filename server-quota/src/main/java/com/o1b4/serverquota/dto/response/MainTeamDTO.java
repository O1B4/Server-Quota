package com.o1b4.serverquota.dto.response;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class MainTeamDTO {

    // main page의 이름, 프로필 사진, url

    private String teamName;

    private String teamProfileImage;

    private String teamUrl;

    private String role;

    @Builder
    public MainTeamDTO(String teamName, String teamProfileImage, String teamUrl, String role) {
        this.teamName = teamName;
        this.teamProfileImage = teamProfileImage;
        this.teamUrl = teamUrl;
        this.role = role;
    }
}
