package com.o1b4.serverquota.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class NotAvailableDateDTO {

    private LocalDate excludeDate;

    @Builder
    public NotAvailableDateDTO(LocalDate excludeDate) {
        this.excludeDate = excludeDate;
    }

}
