package com.o1b4.serverquota.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BelongTeamDTO {

    private Long userId;

    private Long teamId;

    private String userRole;
}
