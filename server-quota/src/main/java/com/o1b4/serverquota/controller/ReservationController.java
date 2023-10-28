package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.ReservationDTO;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.ReservationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // reservId로 reservation 확인
    @GetMapping("/{reservId}")
    public ResponseEntity<ResponseMessage> findReservation(@PathVariable long reservId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        ReservationDTO reservation  = reservationService.findReservation(reservId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservation", reservation);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
