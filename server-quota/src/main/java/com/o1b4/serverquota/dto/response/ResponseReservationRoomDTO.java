package com.o1b4.serverquota.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseReservationRoomDTO {

    private String roomName;

    private String meetingKind;

    private String meetingLocation;

    private LocalDate rangeStart;

    private LocalDate rangeEnd;

    private String durationKind;

    private int duration;

    private List<AvailableTimeDTO> availableTime;

    private List<LocalDate> excludeDate;

    private String roomDescription;

    private String roomUrl;

    @Builder
    public ResponseReservationRoomDTO(String roomName, String meetingKind, String meetingLocation, LocalDate rangeStart, LocalDate rangeEnd, String durationKind, int duration, List<AvailableTimeDTO> availableTime, List<LocalDate> excludeDate, String roomDescription, String roomUrl) {
        this.roomName = roomName;
        this.meetingKind = meetingKind;
        this.meetingLocation = meetingLocation;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.durationKind = durationKind;
        this.duration = duration;
        this.availableTime = availableTime;
        this.excludeDate = excludeDate;
        this.roomDescription = roomDescription;
        this.roomUrl = roomUrl;
    }
}
