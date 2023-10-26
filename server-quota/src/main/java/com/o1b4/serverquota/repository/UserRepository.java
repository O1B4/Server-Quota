package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserId(long userId);
}
