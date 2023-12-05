package com.o1b4.serverquota.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class TokenDTO {
    private Long tokenId;
    private Long userId;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;

    @Builder
    public TokenDTO(Long tokenId, Long userId, String accessToken, String refreshToken, String expiresIn) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }
}
