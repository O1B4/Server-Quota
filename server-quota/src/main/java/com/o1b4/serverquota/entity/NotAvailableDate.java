package com.o1b4.serverquota.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "notavailabledate")
public class NotAvailableDate{

    @Id
    @Column(name = "dateid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dateId;

    @Column(name = "roomid")
    private long roomId;

    @Column(name = "excludeddate")
    private LocalDate excludedDate;

    @Builder
    public NotAvailableDate(long dateId, long roomId, LocalDate excludedDate) {
        this.dateId = dateId;
        this.roomId = roomId;
        this.excludedDate = excludedDate;
    }
}