package com.o1b4.serverquota.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "availabletime")
@Getter
@ToString
@NoArgsConstructor
@IdClass(AvailableTimeId.class)
public class AvailableTime implements Serializable {

    @Id
    @Column(name="roomid")
    private long roomId;

    @Id
    @Column(name = "wday", nullable = false)
    private int wDay;

    @Column(name = "starttime", nullable = false)
    private LocalTime startTime = LocalTime.of(10, 0);

    @Column(name = "endtime", nullable = false)
    private LocalTime endTime = LocalTime.of(19, 0);

    @Builder
    public AvailableTime(long roomId, int wDay, LocalTime startTime, LocalTime endTime) {
        this.roomId = roomId;
        this.wDay = wDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}