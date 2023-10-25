package com.o1b4.serverquota.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// API response Message
public class ResponseMessage {

    private HttpStatus httpStatus;

    private String message;

    private Map<String, Object> results;

}

