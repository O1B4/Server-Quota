package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.response.MainTeamDTO;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.TeamService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    private final TeamService teamService;

    public UserController(TeamService teamService) {
        this.teamService = teamService;
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
}
