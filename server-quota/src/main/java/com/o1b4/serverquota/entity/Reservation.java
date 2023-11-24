package com.o1b4.serverquota.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservId;

    @Column(name = "roomid")
    private long roomId;

    @Column(name = "userid")
    private long userId;

    @Column(name = "reservdate", nullable = false)
    private LocalDate reservDate;

    @Column(name = "reservtime", nullable = false)
    private LocalTime reservTime;

    @Column(name = "reservname", length = 100, nullable = false)
    private String reservName;

    @Column(name = "reservemail", length = 100, nullable = false)
    private String reservEmail;

    @Column(name = "reservmemo", length = 255)
    private String reservMemo;

    @Builder
    public Reservation(Long reservId, long roomId, long userId, LocalDate reservDate, LocalTime reservTime, String reservName, String reservEmail, String reservMemo) {
        this.reservId = reservId;
        this.roomId = roomId;
        this.userId = userId;
        this.reservDate = reservDate;
        this.reservTime = reservTime;
        this.reservName = reservName;
        this.reservEmail = reservEmail;
        this.reservMemo = reservMemo;
    }
}