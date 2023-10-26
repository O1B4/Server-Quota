package com.o1b4.serverquota.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeamMemberDTO {

    private String userName;

    private String userProfileImage;

    @Builder
    public TeamMemberDTO(String userName, String userProfileImage) {
        this.userName = userName;
        this.userProfileImage = userProfileImage;
    }
}
