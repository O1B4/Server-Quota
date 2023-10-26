package com.o1b4.serverquota.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String userEmail;
    private String userName;
    private String userProfileImage;

    @Builder
    public UserDTO(Long userId, String userEmail, String userName, String userProfileImage) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }

}
