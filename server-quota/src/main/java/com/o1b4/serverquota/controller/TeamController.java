package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.response.TeamMemberDTO;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // teamId로 team에 속한 User 이름, 프로필 사진 조회
    @GetMapping("/users/{teamId}")
    public ResponseEntity<ResponseMessage> findTeamMembers(@PathVariable long teamId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<TeamMemberDTO> teamMembers = teamService.findTeamMembersByTeamId(teamId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("teamMembers", teamMembers);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
