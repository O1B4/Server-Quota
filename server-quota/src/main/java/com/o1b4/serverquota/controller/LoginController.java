package com.o1b4.serverquota.controller;

//import com.o1b4.serverquota.google.GoogleOAuth;
import com.o1b4.serverquota.response.ResponseMessage;
import com.o1b4.serverquota.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.nio.charset.StandardCharsets;
        import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login/oauth2/code/{registrationId}")
    public ResponseEntity<ResponseMessage> googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        log.info("google login 진행");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        Map<String, Object> responseMap = loginService.socialLogin(code, registrationId);

        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK.value(), "로그인 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}