package com.o1b4.serverquota.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReservationDTO {

    private LocalDate reservDate;

    private LocalTime reservTime;

    private String userName;

    private String reservName;

    private String reservEmail;

    private String reservMemo;

    @Builder
    public ReservationDTO(String userName, LocalDate reservDate, LocalTime reservTime, String reservName, String reservEmail, String reservMemo) {
        this.userName = userName;
        this.reservDate = reservDate;
        this.reservTime = reservTime;
        this.reservName = reservName;
        this.reservEmail = reservEmail;
        this.reservMemo = reservMemo;
    }
}
