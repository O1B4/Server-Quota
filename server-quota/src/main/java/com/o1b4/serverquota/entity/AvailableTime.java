package com.o1b4.serverquota.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "availableTime")
public class AvailableTime {
    @Id
    @ManyToOne
    @JoinColumn(name="roomId")
    private ReservationRoom room;

    @Column(name = "wDay", nullable = false)
    private int wDay;

    @Column(name = "startTime", nullable = false)
    private LocalTime startTime = LocalTime.of(10, 0);

    @Column(name = "endTime", nullable = false)
    private LocalTime endTime = LocalTime.of(19, 0);
}