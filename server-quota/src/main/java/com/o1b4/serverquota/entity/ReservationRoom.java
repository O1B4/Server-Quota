package com.o1b4.serverquota.entity;

import javax.persistence.*;
import java.time.LocalDate;

enum DurationKind {
    HOUR,
    MINUTE
}

@Entity
@Table(name = "reservationRoom")
public class ReservationRoom {
    @Id
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    @Column(name = "roomName", length = 30, nullable = false)
    private String roomName;

    @Column(name = "meetingKind", length = 255)
    private String meetingKind;

    @Column(name = "meetingLocation", length = 255)
    private String meetingLocation;

    @Column(name = "rangeStart", nullable = false)
    private LocalDate rangeStart = LocalDate.now();

    @Column(name = "rangeEnd", nullable = false)
    private LocalDate rangeEnd = LocalDate.of(9999, 12, 31);

    @Enumerated(EnumType.STRING)
    @Column(name = "durationKind", length = 20, nullable = false)
    private DurationKind durationKind = DurationKind.HOUR;

    @Column(name = "duration")
    private int duration = 1;

    @Column(name = "roomDescription", length = 255)
    private String roomDescription;

    @Column(name = "roomUrl", length = 30, nullable = false)
    private String roomUrl = "meeting" + (int)(Math.random() * 99 + 1);
}