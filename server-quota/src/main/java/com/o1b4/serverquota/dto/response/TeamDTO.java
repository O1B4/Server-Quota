package com.o1b4.serverquota.dto.response;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeamDTO {

    private Long teamId;

    private String teamName;

    @Builder
    public TeamDTO(Long teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }
}
