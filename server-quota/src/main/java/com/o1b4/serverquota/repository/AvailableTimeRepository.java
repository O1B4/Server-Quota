package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {

    List<AvailableTime> getAvailableTimesByRoomId(long roomId);

}
