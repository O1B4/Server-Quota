package com.o1b4.serverquota.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TeamDTO {

    private Long teamId;

    private String teamName;

    private String teamProfileImage;

    private String teamUrl;

    private String teamDescription;
}
