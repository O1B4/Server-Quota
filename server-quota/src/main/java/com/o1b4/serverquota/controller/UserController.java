package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.UserDTO;
import com.o1b4.serverquota.dto.request.RegisterMemberDTO;
import com.o1b4.serverquota.dto.response.MainTeamDTO;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.TeamService;
import com.o1b4.serverquota.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    private final TeamService teamService;
    private final UserService userService;

    public UserController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }


    // UserId로 속한 팀 정보 조회(issue #3 - 1)
    /* @AuthenticationPrincipal OAuth2User principal */
    @GetMapping("/team/{userId}")
    public ResponseEntity<ResponseMessage> findMyTeam(@PathVariable long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        MainTeamDTO myTeam = teamService.findTeamByUserId(userId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("team", myTeam);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // UserId로 User 정보 조회
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseMessage> findUserById(@PathVariable long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        UserDTO user = userService.findUserById(userId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user", user);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<ResponseMessage> checkIfUserExistsByEmail(@RequestParam String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        boolean UserExists = userService.checkIfUserExistsByEmail(email);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("UserExists", UserExists);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseMessage> RegisterMember(@RequestBody RegisterMemberDTO registerMember) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        ResponseMessage responseMessage = new ResponseMessage();

        try {
            userService.RegisterMember(registerMember);
            responseMessage.setMessage("회원 가입 성공");
            responseMessage.setHttpStatus(HttpStatus.OK);

        } catch (CustomApiException e) {
            responseMessage.setMessage(e.getMessage());
            responseMessage.setHttpStatus(e.getHttpStatus());
        }

        return new ResponseEntity<>(responseMessage, headers, responseMessage.getHttpStatus());
    }
}
