package com.o1b4.serverquota.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "token")
public class Token {
    @Id
    private Long tokenId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "refreshToken", length = 65535, nullable = false)
    private String refreshToken;

    @Column(name = "expirationDate", nullable = false)
    private LocalDate expirationDate;
}