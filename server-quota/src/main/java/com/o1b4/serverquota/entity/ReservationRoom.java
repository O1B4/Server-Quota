package com.o1b4.serverquota.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "reservationroom")
public class ReservationRoom {

    @Id
    @Column(name = "roomid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "teamid")
    private Long teamId;

    @Column(name = "roomname", length = 30, nullable = false)
    private String roomName;

    @Column(name = "meetingkind", length = 255)
    private String meetingKind;

    @Column(name = "meetinglocation", length = 255)
    private String meetingLocation;

    @Column(name = "rangestart", nullable = false)
    private LocalDate rangeStart = LocalDate.now();

    @Column(name = "rangeend", nullable = false)
    private LocalDate rangeEnd = LocalDate.of(9999, 12, 31);

    @Enumerated(EnumType.STRING)
    @Column(name = "durationkind", length = 20, nullable = false)
    private DurationKind durationKind = DurationKind.HOUR;

    @Column(name = "duration")
    private int duration = 1;

    @Column(name = "roomdescription", length = 255)
    private String roomDescription;

    @Column(name = "roomurl", length = 30, nullable = false)
    private String roomUrl = "meeting" + (int)(Math.random() * 99 + 1);

    @Builder
    public ReservationRoom(Long roomId, Long userId, Long teamId, String roomName, String meetingKind, String meetingLocation, LocalDate rangeStart, LocalDate rangeEnd, DurationKind durationKind, int duration, String roomDescription, String roomUrl) {
        this.roomId = roomId;
        this.userId = userId;
        this.teamId = teamId;
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

    public void modifyRoom(String roomName, String meetingKind, String meetingLocation, LocalDate rangeStart, LocalDate rangeEnd, DurationKind durationKind, int duration, String roomDescription, String roomUrl) {
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