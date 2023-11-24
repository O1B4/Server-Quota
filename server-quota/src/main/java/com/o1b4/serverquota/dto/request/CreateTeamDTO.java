package com.o1b4.serverquota.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateTeamDTO {

    private String teamName;

    // 팀을 만든 사람
    private long userId;

    private String teamProfileImage;

    private String teamUrl;

    private String teamDescription;
}
