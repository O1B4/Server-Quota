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

    @Column(name = "expriresin", nullable = false)
    private String expiresIn;

    @Builder
    public Token(Long userId, String accessToken, String refreshToken, String expiresIn) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }
}