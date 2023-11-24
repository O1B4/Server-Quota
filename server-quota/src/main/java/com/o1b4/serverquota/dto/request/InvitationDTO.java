package com.o1b4.serverquota.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDTO {

    private long teamId;

    private String email;

    // 원래는 isAdvisor 였으나 @Getter 문제로 is 삭제
    private boolean advisor;

}
