package com.o1b4.serverquota.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

enum DurationKind {
    HOUR,
    MINUTE
}

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservationroom")
public class ReservationRoom {

    @Id
    @Column(name = "roomid")
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

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

}