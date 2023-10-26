package com.o1b4.serverquota.dto.response;

import lombok.*;

import java.time.LocalDate;

// ReservationRoom에서 예약 생성자의 이름, 프로필 사진 추가
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MainReservationRoomDTO {

    private String roomName;

    private String durationKind;

    private int duration;

    private String meetingKind;

    private String userName;

    private String userProfileImage;

    private LocalDate rangeStart;

    private LocalDate rangeEnd;

    private String roomUrl;

    @Builder
    public MainReservationRoomDTO(String roomName, String durationKind, int duration, String meetingKind, String userName, String userProfileImage, LocalDate rangeStart, LocalDate rangeEnd, String roomUrl) {
        this.roomName = roomName;
        this.durationKind = durationKind;
        this.duration = duration;
        this.meetingKind = meetingKind;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.roomUrl = roomUrl;
    }
}
