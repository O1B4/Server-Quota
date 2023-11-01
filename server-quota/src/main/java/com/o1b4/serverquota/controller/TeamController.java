package com.o1b4.serverquota.controller;

import com.o1b4.serverquota.dto.request.CreateTeamDTO;
import com.o1b4.serverquota.dto.request.InvitationDTO;
import com.o1b4.serverquota.dto.response.RolelessMainTeamDTO;
import com.o1b4.serverquota.dto.response.TeamMemberDTO;
import com.o1b4.serverquota.exception.CustomApiException;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.TeamService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseMessage> findAllBelongTeams(@PathVariable long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<String> Teams = teamService.findTeamsByUserId(userId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("Teams", Teams);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/check-team-url/{teamUrl}")
    public ResponseEntity<ResponseMessage> checkIfUrlIsUsable(@PathVariable String teamUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        boolean isUrlUsable = teamService.checkIfUrlIsUsable(teamUrl);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isUrlUsable", isUrlUsable);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // teamID로 팀 정보 불러오기
    @GetMapping("/info/{teamId}")
    public ResponseEntity<ResponseMessage> findTeam(@PathVariable long teamId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        RolelessMainTeamDTO team = teamService.findTeamByTeamId(teamId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("team", team);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    // teamId로 teamUrl 불러오기
    @GetMapping("/link/{teamId}")
    public ResponseEntity<ResponseMessage> findTeamUrl(@PathVariable long teamId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        String team = teamService.findTeamUrl(teamId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("teamUrl", team);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseMessage> CreateTeam(@RequestBody CreateTeamDTO team) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        ResponseMessage responseMessage = new ResponseMessage();

        try {
            teamService.CreateTeam(team);
            responseMessage.setMessage("팀 생성 성공");
            responseMessage.setHttpStatus(HttpStatus.OK);

        } catch (CustomApiException e) {
            responseMessage.setMessage(e.getMessage());
            responseMessage.setHttpStatus(e.getHttpStatus());
        }

        return new ResponseEntity<>(responseMessage, headers, responseMessage.getHttpStatus());
    }

    @PostMapping("/invitation")
    public ResponseEntity<ResponseMessage> teamInvitation(@RequestBody InvitationDTO invitation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        ResponseMessage responseMessage = new ResponseMessage();

        Map<String, Object> responseMap = new HashMap<>();

        try {
            String role = String.valueOf(teamService.teamInvitation(invitation));
            responseMessage.setMessage("유저 초대 성공");
            responseMessage.setHttpStatus(HttpStatus.OK);

            responseMap.put("userRole", role);

        } catch (CustomApiException e) {
            responseMessage.setMessage(e.getMessage());
            responseMessage.setHttpStatus(e.getHttpStatus());
        }

        return new ResponseEntity<>(responseMessage, headers, responseMessage.getHttpStatus());
    }
}
