package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.ReservationDTO;
import com.o1b4.serverquota.entity.Reservation;
import com.o1b4.serverquota.entity.User;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.repository.ReservationRepository;
import com.o1b4.serverquota.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;

    public ReservationService(ReservationRepository repository, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }


    public ReservationDTO findReservation(long reservId) {

        Reservation reservation = reservationRepository.findReservationByReservId(reservId)
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "조회된 예약이 없습니다."));

        User user = userRepository.findUserByUserId(reservation.getUserId())
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "예약을 만든 회원이 없습니다."));

        return ReservationDTO.builder()
                .reservDate(reservation.getReservDate())
                .reservTime(reservation.getReservTime())
                .reservEmail(reservation.getReservEmail())
                .reservName(reservation.getReservName())
                .userName(user.getUserName())
                .reservMemo(reservation.getReservMemo())
                .build();
    }

    public List<ReservationDTO> findReservations(long roomId) {
        List<Reservation> reservations = reservationRepository.findReservationByRoomId(roomId);

        return reservations.stream()
                .map(
                        reservation -> ReservationDTO.builder()
                                .reservDate(reservation.getReservDate())
                                .reservTime(reservation.getReservTime())
                                .reservEmail(reservation.getReservEmail())
                                .reservName(reservation.getReservName())
                                .userName(
                                        userRepository.findUserByUserId(reservation.getUserId())
                                                        .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "예약을 만든 회원이 없습니다."))
                                                        .getUserName()
                                        )
                                .reservMemo(reservation.getReservMemo())
                                        .build()
                )
                .collect(Collectors.toList());
    }
}
