package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.response.MainReservationRoomDTO;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.RoomService;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // teamID로 해당되는 모든 예약 룸 정보 조회
    @GetMapping("/{teamId}")
    public ResponseEntity<ResponseMessage> findReservationRoom(@PathVariable long teamId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<MainReservationRoomDTO> rooms  = roomService.findReservationRoomsByTeamId(teamId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservationRooms", rooms);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
