package com.o1b4.serverquota.dto;

import java.time.LocalTime;

public class AvailableTimeDTO {
    private Long roomId;
    private int wDay;
    private LocalTime startTime;
    private LocalTime endTime;

    public AvailableTimeDTO() {

    }

    public AvailableTimeDTO(Long roomId, int wDay, LocalTime startTime, LocalTime endTime) {
        this.roomId = roomId;
        this.wDay = wDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getwDay() {
        return wDay;
    }

    public void setwDay(int wDay) {
        this.wDay = wDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "AvailableTimeDTO{" +
                "roomId=" + roomId +
                ", wDay=" + wDay +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
