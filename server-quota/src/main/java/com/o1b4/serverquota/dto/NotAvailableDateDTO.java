package com.o1b4.serverquota.dto;

import java.time.LocalDate;

public class NotAvailableDateDTO {
    private Long roomId;
    private LocalDate excludeDate;

    public NotAvailableDateDTO() {

    }

    public NotAvailableDateDTO(Long roomId, LocalDate excludeDate) {
        this.roomId = roomId;
        this.excludeDate = excludeDate;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getExcludeDate() {
        return excludeDate;
    }

    public void setExcludeDate(LocalDate excludeDate) {
        this.excludeDate = excludeDate;
    }

    @Override
    public String toString() {
        return "NotAvailableDateDTO{" +
                "roomId=" + roomId +
                ", excludeDate=" + excludeDate +
                '}';
    }
}
