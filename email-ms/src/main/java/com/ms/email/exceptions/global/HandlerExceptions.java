package com.ms.email.exceptions.global;

import com.ms.email.exceptions.EmailException;
import com.ms.email.exceptions.Error;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@SuppressWarnings("unused")
public class HandlerExceptions {

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Error> handleValidationException(HttpServletRequest s, DuplicateKeyException e) {
        return Error.response(e.getMessage(), HttpStatus.CONFLICT, s.getRequestURI());
    }

}
