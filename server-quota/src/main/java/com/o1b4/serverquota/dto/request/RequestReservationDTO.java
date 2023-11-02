package com.o1b4.serverquota.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestReservationDTO {

    private long roomId;

    private long userId;

    private LocalDate reservDate;

    private LocalTime reservTime;

    private String reservName;

    private String reservEmail;

    private String reservMemo;

    @Builder
    public RequestReservationDTO(long roomId, long userId, LocalDate reservDate, LocalTime reservTime, String reservName, String reservEmail, String reservMemo) {
        this.roomId = roomId;
        this.userId = userId;
        this.reservDate = reservDate;
        this.reservTime = reservTime;
        this.reservName = reservName;
        this.reservEmail = reservEmail;
        this.reservMemo = reservMemo;
    }
}
