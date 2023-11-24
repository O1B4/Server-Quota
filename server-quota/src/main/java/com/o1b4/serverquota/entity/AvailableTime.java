package com.o1b4.serverquota.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "availabletime")
@Getter
@ToString
@NoArgsConstructor
@IdClass(AvailableTimeId.class)
@AllArgsConstructor
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

}