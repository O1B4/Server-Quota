package com.o1b4.serverquota.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SimpleReservationRoomDTO {

    private String advisorName;

    private String reservationName;

    private int duration;

    private String meetingLocation;

    private String roomDescription;


    @Builder
    public SimpleReservationRoomDTO(String advisorName, String reservationName, int duration, String meetingLocation, String roomDescription) {
        this.advisorName = advisorName;
        this.reservationName = reservationName;
        this.duration = duration;
        this.meetingLocation = meetingLocation;
        this.roomDescription = roomDescription;
    }
}
