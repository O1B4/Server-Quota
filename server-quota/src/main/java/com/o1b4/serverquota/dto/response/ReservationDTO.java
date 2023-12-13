package com.o1b4.serverquota.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReservationDTO {

    private Long reservId;

    private LocalDate reservDate;

    private LocalTime reservTime;

    private String userName;

    private String reservName;

    private String reservEmail;

    private String reservMemo;

    @Builder
    public ReservationDTO(Long reservId, LocalDate reservDate, LocalTime reservTime, String userName, String reservName, String reservEmail, String reservMemo) {
        this.reservId = reservId;
        this.reservDate = reservDate;
        this.reservTime = reservTime;
        this.userName = userName;
        this.reservName = reservName;
        this.reservEmail = reservEmail;
        this.reservMemo = reservMemo;
    }
}
