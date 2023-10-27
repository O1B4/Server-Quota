package com.o1b4.serverquota.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notavailabledate")
public class NotAvailableDate{

    @Id
    @Column(name = "dateid")
    private long dateId;

    @Column(name = "roomid")
    private long roomId;

    @Column(name = "excludeddate")
    private LocalDate excludedDate;

}