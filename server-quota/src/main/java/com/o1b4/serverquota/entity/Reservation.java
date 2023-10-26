package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@ToString
@Table(name = "reservation")
public class Reservation {
    @Id
    private Long reservId;

    @ManyToOne
    @JoinColumn(name = "roomid")
    private ReservationRoom room;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

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

    public Reservation() {
    }

    public Reservation(Long reservId, ReservationRoom room, User user, LocalDate reservDate, LocalTime reservTime, String reservName, String reservEmail, String reservMemo) {
        this.reservId = reservId;
        this.room = room;
        this.user = user;
        this.reservDate = reservDate;
        this.reservTime = reservTime;
        this.reservName = reservName;
        this.reservEmail = reservEmail;
        this.reservMemo = reservMemo;
    }
}