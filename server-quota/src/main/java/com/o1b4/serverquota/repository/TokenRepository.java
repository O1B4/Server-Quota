package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
