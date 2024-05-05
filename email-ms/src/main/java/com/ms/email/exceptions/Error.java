package com.ms.email.exceptions;

import com.ms.email.utils.Time;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
public record Error(String timestamp, Integer status, String error, String path) {

    public static ResponseEntity<Error> response (String message, HttpStatus status, String uri){
        return ResponseEntity
                .status(status)
                .body(Error.builder()
                           .timestamp(Time.getTime())
                           .error(message)
                           .status(status.value())
                           .path(uri)
                           .build()
                );
    }
}