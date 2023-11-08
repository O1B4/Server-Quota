package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.request.RequestReservationDTO;
import com.o1b4.serverquota.dto.response.ReservationDTO;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.ReservationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/room/{roomId}")
    public ResponseEntity<ResponseMessage> findReservations(@PathVariable long roomId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<ReservationDTO> reservations  = reservationService.findReservations(roomId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservations", reservations);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseMessage> CreateReservation(@RequestBody RequestReservationDTO reservation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservation", reservation);

        reservationService.CreateReservation(reservation);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "예약 생성 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PutMapping("/{reservId}")
    public ResponseEntity<ResponseMessage> modifyReservation(@PathVariable long reservId, @RequestBody RequestReservationDTO reservation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        Map<String, Object> responseMap = new HashMap<>();

        reservationService.modifyReservation(reservId, reservation);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "예약 수정 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

}
