package com.o1b4.serverquota.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.o1b4.serverquota.dto.TokenDTO;
import com.o1b4.serverquota.dto.UserDTO;
import com.o1b4.serverquota.entity.Token;
import com.o1b4.serverquota.entity.User;
import com.o1b4.serverquota.repository.TokenRepository;
import com.o1b4.serverquota.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class LoginService {

    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public LoginService(Environment env, UserRepository userRepository, TokenRepository tokenRepository) {
        this.env = env;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public Map<String, Object> socialLogin(String code, String registrationId) {
        TokenDTO tokenInfo = getAccessToken(code, registrationId);
        String accessToken = tokenInfo.getAccessToken();
        UserDTO userInfo = getUserResource(accessToken, registrationId);

        boolean isUser = userRepository.existsByUserEmail(userInfo.getUserEmail());

        if (isUser) {
            log.info("회원가입 필요한 유저");
            User user = new User(userInfo);
            userRepository.save(user);
        }
        Token token = new Token(tokenInfo);
        tokenRepository.save(token);

        Token userToken = tokenRepository.findTokenByUserId(userInfo.getUserId());

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userInfo", userInfo);
        userMap.put("tokenInfo", userToken);
        return userMap;
    }

    private TokenDTO getAccessToken(String authorizationCode, String registrationId) {
        String clientId = env.getProperty("spring.security.oauth2." + registrationId + ".client-id");
        String clientSecret = env.getProperty("spring.security.oauth2." + registrationId + ".client-secret");
        String redirectUri = env.getProperty("spring.security.oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("spring.security.oauth2." + registrationId + ".token-uri");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();

        JsonNode refreshTokenNode = accessTokenNode.get("refresh_token");
        String refreshToken = refreshTokenNode != null ? refreshTokenNode.asText() : null;

        UserDTO userDTO = getUserResource(accessTokenNode.get("access_token").asText(), "google");

        TokenDTO tokenInfo = TokenDTO.builder()
                .userId(userDTO.getUserId())
                .accessToken(accessTokenNode.get("access_token").asText())
                .expiresIn(accessTokenNode.get("expires_in").asText())
                .refreshToken(refreshToken)
                .build();

        return tokenInfo;
    }

    private UserDTO getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("spring.security.oauth2." + registrationId + ".resource-uri");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);

        JsonNode userResourceNode = restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();

        log.info("userResource 정보 : {}", userResourceNode);

        UserDTO userInfo = UserDTO.builder()
                .userId(userResourceNode.get("id").asLong())
                .userName(userResourceNode.get("name").asText())
                .userEmail(userResourceNode.get("email").asText())
                .userProfileImage(userResourceNode.get("picture").asText())
                .build();

        return userInfo;
    }
}