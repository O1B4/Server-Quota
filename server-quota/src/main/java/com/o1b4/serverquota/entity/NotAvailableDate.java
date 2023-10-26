package com.o1b4.serverquota.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@Table(name = "notavailabledate")
public class NotAvailableDate implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="roomid")
    private ReservationRoom room;

    @Column(name = "excludeddate")
    private LocalDate excludedDate;

    public NotAvailableDate() {
    }

    public NotAvailableDate(ReservationRoom room, LocalDate excludedDate) {
        this.room = room;
        this.excludedDate = excludedDate;
    }
}