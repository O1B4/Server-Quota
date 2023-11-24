package com.o1b4.serverquota.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvitedUserDTO {
    private String userName;

    private Long teamName;

    private String userRole;
}
