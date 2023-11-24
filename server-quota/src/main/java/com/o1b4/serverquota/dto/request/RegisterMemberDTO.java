package com.o1b4.serverquota.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMemberDTO {

    private String userEmail;

    private String userName;

    private String userProfileImage;

}