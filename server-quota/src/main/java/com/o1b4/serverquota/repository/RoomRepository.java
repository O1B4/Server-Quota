package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.ReservationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<ReservationRoom, Long> {

    List<ReservationRoom> findReservationRoomsByTeamId(long teamId);

    ReservationRoom findReservationRoomByRoomId(long roomId);

    Boolean existsByRoomUrl(String roomUrl);
}
