package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findReservationByReservId(long ReservId);

    List<Reservation> findReservationByRoomId(long roomId);
}
