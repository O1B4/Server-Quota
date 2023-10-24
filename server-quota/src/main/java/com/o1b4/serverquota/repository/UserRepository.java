package com.o1b4.serverquota.repository;

import com.o1b4.serverquota.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
