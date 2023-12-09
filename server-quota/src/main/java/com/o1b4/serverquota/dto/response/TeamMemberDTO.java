package com.o1b4.serverquota.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeamMemberDTO {

    private Long userId;

    private String userName;

    private String userProfileImage;

    @Builder
    public TeamMemberDTO(Long userId, String userName, String userProfileImage) {
        this.userId = userId;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }
}
