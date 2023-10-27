package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.NotAvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotAvailableDateRepository extends JpaRepository<NotAvailableDate, Long> {
    List<NotAvailableDate> findAllByRoomId(long roomId);
}
