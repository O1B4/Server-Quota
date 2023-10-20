package com.o1b4.serverquota.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    private Long reservId;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private ReservationRoom room;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "reservDate", nullable = false)
    private LocalDate reservDate;

    @Column(name = "reservTime", nullable = false)
    private LocalTime reservTime;

    @Column(name = "reservName", length = 100, nullable = false)
    private String reservName;

    @Column(name = "reservEmail", length = 100, nullable = false)
    private String reservEmail;

    @Column(name = "reservMemo", length = 255)
    private String reservMemo;
}