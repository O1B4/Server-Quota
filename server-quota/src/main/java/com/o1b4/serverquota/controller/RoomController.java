package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.request.RequestReservationRoomDTO;
import com.o1b4.serverquota.dto.response.MainReservationRoomDTO;
import com.o1b4.serverquota.dto.response.ResponseReservationRoomDTO;
import com.o1b4.serverquota.dto.response.SimpleReservationRoomDTO;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.RoomService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // teamID로 해당되는 모든 예약 룸 정보 조회
    @GetMapping("/team/{teamId}")
    public ResponseEntity<ResponseMessage> findReservationRoom(@PathVariable long teamId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<MainReservationRoomDTO> rooms  = roomService.findReservationRoomsByTeamId(teamId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservationRooms", rooms);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK.value(), "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<ResponseMessage> findReservationRoomByRoomId(@PathVariable long roomId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        ResponseReservationRoomDTO room  = roomService.findReservationRoomByRoomId(roomId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservationRoom", room);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK.value(), "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/check-room-url/{roomUrl}")
    public ResponseEntity<ResponseMessage> checkRoomUrl(@PathVariable String roomUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        boolean isUrlUsable  = roomService.checkRoomUrl(roomUrl);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isUrlUsable", isUrlUsable);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK.value(), "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/simple/{roomId}")
    public ResponseEntity<ResponseMessage> findSimpleReservationRoom(@PathVariable long roomId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        SimpleReservationRoomDTO room  = roomService.findSimpleReservationRoom(roomId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservationRoom", room);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK.value(), "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseMessage> CreateReserveRoom(@RequestBody RequestReservationRoomDTO room) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reservationRoom", room);

        roomService.CreateReserveRoom(room);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK.value(), "예약 룸 생성 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<ResponseMessage> modifyRoom(@PathVariable long roomId, @RequestBody RequestReservationRoomDTO room) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        ResponseMessage responseMessage = new ResponseMessage();

        Map<String, Object> responseMap = new HashMap<>();

        try {
            roomService.modifyRoom(roomId, room);
            responseMessage.setMessage("예약 룸 수정 성공");
            responseMessage.setHttpStatus(HttpStatus.OK.value());

        } catch (CustomApiException e) {
            responseMessage.setMessage(e.getMessage());
            responseMessage.setHttpStatus(e.getHttpStatus().value());
        }

        return new ResponseEntity<>(responseMessage, headers, responseMessage.getHttpStatus());
    }
}
