package com.o1b4.serverquota.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservid")
    private Long reservId;

    @Column(name = "roomid")
    private long roomId;

    @Column(name = "userid")
    private long userId;

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

}