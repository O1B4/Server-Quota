package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@Table(name = "token")
public class Token {
    @Id
    private Long tokenId;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "refreshtoken", length = 65535, nullable = false)
    private String refreshToken;

    @Column(name = "exprationdate", nullable = false)
    private LocalDate expirationDate;

    public Token() {
    }

    public Token(Long tokenId, User user, String refreshToken, LocalDate expirationDate) {
        this.tokenId = tokenId;
        this.user = user;
        this.refreshToken = refreshToken;
        this.expirationDate = expirationDate;
    }
}