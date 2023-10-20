package com.o1b4.serverquota.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "notAvailableDate")
public class NotAvailableDate {
    @Id
    @ManyToOne
    @JoinColumn(name="roomId")
    private ReservationRoom room;

    @Column(name = "excludedDate")
    private LocalDate excludedDate;
}