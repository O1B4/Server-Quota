package com.o1b4.serverquota.service;

import com.o1b4.serverquota.dto.UserDTO;
import com.o1b4.serverquota.entity.User;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDTO findUserById(long userId) {
        // 해당 user의 첫 번째 소속팀의 Team
        User user = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND, "회원을 조회할 수 없습니다."));

        return UserDTO.builder()
                .userId(user.getUserId())
                .userEmail(user.getUserEmail())
                .userName(user.getUserName())
                .userProfileImage(user.getUserProfileImage())
                .build();
    }

    public boolean checkIfUserExistsByEmail(String email) {

        return userRepository.existsByUserEmail(email);
    }
}
