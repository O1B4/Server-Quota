package com.o1b4.serverquota.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDTO {
    private Long reservId;
    private Long roomId;
    private Long userId;
    private LocalDate reservDate;
    private LocalTime reservTime;
    private String reservName;
    private String reservEmail;
    private String reservMemo;

    public ReservationDTO() {

    }

    public ReservationDTO(Long reservId, Long roomId, Long userId, LocalDate reservDate, LocalTime reservTime, String reservName, String reservEmail, String reservMemo) {
        this.reservId = reservId;
        this.roomId = roomId;
        this.userId = userId;
        this.reservDate = reservDate;
        this.reservTime = reservTime;
        this.reservName = reservName;
        this.reservEmail = reservEmail;
        this.reservMemo = reservMemo;
    }

    public Long getReservId() {
        return reservId;
    }

    public void setReservId(Long reservId) {
        this.reservId = reservId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getReservDate() {
        return reservDate;
    }

    public void setReservDate(LocalDate reservDate) {
        this.reservDate = reservDate;
    }

    public LocalTime getReservTime() {
        return reservTime;
    }

    public void setReservTime(LocalTime reservTime) {
        this.reservTime = reservTime;
    }

    public String getReservName() {
        return reservName;
    }

    public void setReservName(String reservName) {
        this.reservName = reservName;
    }

    public String getReservEmail() {
        return reservEmail;
    }

    public void setReservEmail(String reservEmail) {
        this.reservEmail = reservEmail;
    }

    public String getReservMemo() {
        return reservMemo;
    }

    public void setReservMemo(String reservMemo) {
        this.reservMemo = reservMemo;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "reservId=" + reservId +
                ", roomId=" + roomId +
                ", userId=" + userId +
                ", reservDate=" + reservDate +
                ", reservTime=" + reservTime +
                ", reservName='" + reservName + '\'' +
                ", reservEmail='" + reservEmail + '\'' +
                ", reservMemo='" + reservMemo + '\'' +
                '}';
    }
}
