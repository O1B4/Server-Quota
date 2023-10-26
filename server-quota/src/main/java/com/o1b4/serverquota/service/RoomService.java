package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.response.MainReservationRoomDTO;
import com.o1b4.serverquota.entity.ReservationRoom;
import com.o1b4.serverquota.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;


    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<MainReservationRoomDTO> findReservationRoomsByTeamId(long teamId) {
        List<ReservationRoom> rooms = roomRepository.findReservationRoomsByTeamId(teamId);

        // list에 해당하는 room들 DTO 매핑
        return rooms.stream()
                .map(room -> MainReservationRoomDTO.builder()
                        .roomName(room.getRoomName())
                        .durationKind(String.valueOf(room.getDurationKind()))
                        .duration(room.getDuration())
                        .meetingKind(room.getMeetingKind())
                        .userName(room.getUser().getUserName())
                        .userProfileImage(room.getUser().getUserProfileImage())
                        .rangeStart(room.getRangeStart())
                        .rangeEnd(room.getRangeEnd())
                        .roomUrl(room.getRoomUrl())
                .build())
                .collect(Collectors.toList());
    }
}
