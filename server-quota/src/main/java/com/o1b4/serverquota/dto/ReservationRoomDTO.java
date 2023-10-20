package com.o1b4.serverquota.dto;

import java.time.LocalDate;

public class ReservationRoomDTO {
    private Long roomId;
    private Long userId;
    private Long teamId;
    private String roomName;
    private String meetingKind;
    private String meetingLocation;
    private LocalDate rangeStart;
    private LocalDate rangeEnd;
    private String durationKind;
    private int duration;
    private String roomDescription;
    private String roomUrl;

    public ReservationRoomDTO() {

    }

    public ReservationRoomDTO(Long roomId, Long userId, Long teamId, String roomName, String meetingKind, String meetingLocation, LocalDate rangeStart, LocalDate rangeEnd, String durationKind, int duration, String roomDescription, String roomUrl) {
        this.roomId = roomId;
        this.userId = userId;
        this.teamId = teamId;
        this.roomName = roomName;
        this.meetingKind = meetingKind;
        this.meetingLocation = meetingLocation;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.durationKind = durationKind;
        this.duration = duration;
        this.roomDescription = roomDescription;
        this.roomUrl = roomUrl;
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getMeetingKind() {
        return meetingKind;
    }

    public void setMeetingKind(String meetingKind) {
        this.meetingKind = meetingKind;
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    public LocalDate getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(LocalDate rangeStart) {
        this.rangeStart = rangeStart;
    }

    public LocalDate getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(LocalDate rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public String getDurationKind() {
        return durationKind;
    }

    public void setDurationKind(String durationKind) {
        this.durationKind = durationKind;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
    }

    @Override
    public String toString() {
        return "ReservationRoomDTO{" +
                "roomId=" + roomId +
                ", userId=" + userId +
                ", teamId=" + teamId +
                ", roomName='" + roomName + '\'' +
                ", meetingKind='" + meetingKind + '\'' +
                ", meetingLocation='" + meetingLocation + '\'' +
                ", rangeStart=" + rangeStart +
                ", rangeEnd=" + rangeEnd +
                ", durationKind='" + durationKind + '\'' +
                ", duration=" + duration +
                ", roomDescription='" + roomDescription + '\'' +
                ", roomUrl='" + roomUrl + '\'' +
                '}';
    }
}
