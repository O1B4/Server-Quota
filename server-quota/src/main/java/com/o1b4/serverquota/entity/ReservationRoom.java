package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

enum DurationKind {
    HOUR,
    MINUTE
}

@Entity
@Getter
@ToString
@Table(name = "reservationroom")
public class ReservationRoom {
    @Id
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "teamid")
    private Team team;

    @Column(name = "roomname", length = 30, nullable = false)
    private String roomName;

    @Column(name = "meetingkind", length = 255)
    private String meetingKind;

    @Column(name = "meetinglocation", length = 255)
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

    public ReservationRoom() {
    }

    public ReservationRoom(Long roomId, User user, Team team, String roomName, String meetingKind, String meetingLocation, LocalDate rangeStart, LocalDate rangeEnd, DurationKind durationKind, int duration, String roomDescription, String roomUrl) {
        this.roomId = roomId;
        this.user = user;
        this.team = team;
        this.roomName = roomName;
        this.meetingKind = meetingKind;
        this.meetingLocation = meetingLocation;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.durationKind = durationKind;
        this.duration = duration;
        this.roomDescription = roomDescription;
        this.roomUrl = roomUrl;
    }
}