package com.o1b4.serverquota.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.o1b4.serverquota.dto.response.AvailableTimeDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestReservationRoomDTO {

    // room을 만든 사람
    private long userId;

    private long teamId;

    private String roomName;

    private String meetingKind;

    private String meetingLocation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rangeStart;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rangeEnd;

    private String durationKind;

    private int duration;

    private List<AvailableTimeDTO> availableTime;

    @JsonSerialize(using = JsonDateSerializer.class)
    private List<LocalDate> excludeDate;

    private String roomDescription;

    private String roomUrl;

    @Builder
    public RequestReservationRoomDTO(long userId, long teamId, String roomName, String meetingKind, String meetingLocation, LocalDate rangeStart, LocalDate rangeEnd, String durationKind, int duration, List<AvailableTimeDTO> availableTime, List<LocalDate> excludeDate, String roomDescription, String roomUrl) {
        this.userId = userId;
        this.teamId = teamId;
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
