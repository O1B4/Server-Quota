package com.o1b4.serverquota.dto;

import com.o1b4.serverquota.entity.User;

import java.time.LocalDate;

public class TokenDTO {
    private Long tokenId;
    private Long userId;
    private String refreshToken;
    private LocalDate expirationDate;

    public TokenDTO() {

    }

    public TokenDTO(Long tokenId, Long userId, String refreshToken, LocalDate expirationDate) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.refreshToken = refreshToken;
        this.expirationDate = expirationDate;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "tokenId=" + tokenId +
                ", userId=" + userId +
                ", refreshToken='" + refreshToken + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
