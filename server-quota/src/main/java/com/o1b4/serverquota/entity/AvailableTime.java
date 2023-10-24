package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "availabletime")
@Getter
@ToString
public class AvailableTime implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="roomid")
    private ReservationRoom room;

    @Column(name = "wday", nullable = false)
    private int wDay;

    @Column(name = "starttime", nullable = false)
    private LocalTime startTime = LocalTime.of(10, 0);

    @Column(name = "endtime", nullable = false)
    private LocalTime endTime = LocalTime.of(19, 0);

    public AvailableTime() {
    }

    public AvailableTime(ReservationRoom room, int wDay, LocalTime startTime, LocalTime endTime) {
        this.room = room;
        this.wDay = wDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}