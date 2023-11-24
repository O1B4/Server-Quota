package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.response.AvailableTimeDTO;
import com.o1b4.serverquota.dto.response.MainReservationRoomDTO;
import com.o1b4.serverquota.dto.response.ReservationRoomDTO;
import com.o1b4.serverquota.dto.response.SimpleReservationRoomDTO;
import com.o1b4.serverquota.entity.AvailableTime;
import com.o1b4.serverquota.entity.NotAvailableDate;
import com.o1b4.serverquota.entity.ReservationRoom;
import com.o1b4.serverquota.entity.User;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.repository.AvailableTimeRepository;
import com.o1b4.serverquota.repository.NotAvailableDateRepository;
import com.o1b4.serverquota.repository.RoomRepository;
import com.o1b4.serverquota.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    private final AvailableTimeRepository availableTimeRepository;
    private final UserRepository userRepository;
    private final NotAvailableDateRepository notAvailableDateRepository;


    public RoomService(RoomRepository roomRepository, AvailableTimeRepository availableTimeRepository, UserRepository userRepository, NotAvailableDateRepository notAvailableDateRepository) {
        this.roomRepository = roomRepository;
        this.availableTimeRepository = availableTimeRepository;
        this.userRepository = userRepository;
        this.notAvailableDateRepository = notAvailableDateRepository;
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

    public ReservationRoomDTO findReservationRoomByRoomId(long roomId) {

        ReservationRoom room = roomRepository.findReservationRoomByRoomId(roomId)
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "해당 예약 룸은 존재하지 않습니다!"));

        List<AvailableTime> availableTimes = availableTimeRepository.getAvailableTimesByRoomId(roomId);
        List<NotAvailableDate> NotAvailableDates = notAvailableDateRepository.findAllByRoomId(roomId);

        // availableTime 매핑
        List<AvailableTimeDTO> availableTimeDTOS = availableTimes
                .stream()
                .map(
                        availableTime -> AvailableTimeDTO.builder()
                                .wDay(availableTime.getWDay())
                                .startTime(availableTime.getStartTime())
                                .endTime(availableTime.getEndTime())
                                .build()
                ).collect(Collectors.toList());

        // NotAvailableDate 날짜 리스트
        List<LocalDate> notAvailableDates = NotAvailableDates.stream()
                                            .map(NotAvailableDate::getExcludedDate)
                                            .collect(Collectors.toList());

        // 조립
        return ReservationRoomDTO.builder()
                .roomName(room.getRoomName())
                .meetingKind(room.getMeetingKind())
                .meetingLocation(room.getMeetingLocation())
                .rangeStart(room.getRangeStart())
                .rangeEnd(room.getRangeEnd())
                .durationKind(String.valueOf(room.getDurationKind()))
                .duration(room.getDuration())
                .availableTimeDTOS(availableTimeDTOS)
                .excludeDate(notAvailableDates)
                .roomDescription(room.getRoomDescription())
                .roomUrl(room.getRoomUrl())
                .build();
    }

    public boolean checkRoomUrl(String roomUrl) {

        return !roomRepository.existsByRoomUrl(roomUrl);
    }

    public SimpleReservationRoomDTO findSimpleReservationRoom(long roomId) {

        ReservationRoom room = roomRepository.findReservationRoomByRoomId(roomId)
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "해당 예약룸이 조회되지 않습니다."));

        // 예약 룸 만든 회원 조회
        User user = userRepository.findUserByUserId(room.getUser().getUserId())
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "예약을 만든 회원이 존재하지 않습니다."));

        return SimpleReservationRoomDTO.builder()
                .advisorName(user.getUserName())
                .reservationName(room.getRoomName())
                .duration(room.getDuration())
                .meetingLocation(room.getMeetingLocation())
                .roomDescription(room.getRoomDescription())
                .build();
    }
}
