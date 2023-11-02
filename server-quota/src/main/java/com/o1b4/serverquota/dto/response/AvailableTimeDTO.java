package com.o1b4.serverquota.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalTime;

@Setter
@ToString
@NoArgsConstructor
public class AvailableTimeDTO {

    private int wDay;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;

    public int getwDay() {
        return wDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Builder
    public AvailableTimeDTO(int wDay, LocalTime startTime, LocalTime endTime) {
        this.wDay = wDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
