package com.o1b4.serverquota.dto.response;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AvailableTimeDTO {

    private int wDay;

    private LocalTime startTime;

    private LocalTime endTime;

    @Builder
    public AvailableTimeDTO(int wDay, LocalTime startTime, LocalTime endTime) {
        this.wDay = wDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
