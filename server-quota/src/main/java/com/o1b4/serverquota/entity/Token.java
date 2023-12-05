package com.o1b4.serverquota.entity;

import com.o1b4.serverquota.dto.TokenDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @Column
    private Long userId;

    @Column(name = "accesstoken", nullable = false)
    private String accessToken;

    @Column(name = "refreshtoken")
    private String refreshToken;

    @Column(name = "exprationdate", nullable = false)
    private String expiresIn;

    public Token(TokenDTO tokenDTO) {
        this.userId = tokenDTO.getUserId();
        this.accessToken = tokenDTO.getAccessToken();
        this.refreshToken = tokenDTO.getRefreshToken();
        this.expiresIn = tokenDTO.getExpiresIn();
        // User 정보는 필요에 따라 설정
    }

    @Builder
    public Token(Long userId, String accessToken, String refreshToken, String expiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }
}