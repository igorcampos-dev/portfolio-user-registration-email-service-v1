package com.ms.user.exceptions.global;

import com.ms.user.exceptions.Error;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@SuppressWarnings("unused")
@ApiResponse(description = "Usuário já existe no banco de dados", responseCode = "409")
@ApiResponse(description = "Falta de algum campo, campo nulo ou campo inválido", responseCode = "400")
public class HandlerExceptions {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Error> handleValidationException(HttpServletRequest s, DuplicateKeyException e) {
        return Error.response(e.getMessage(), HttpStatus.CONFLICT, s.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> methodArgumentInvalidException(MethodArgumentNotValidException e, HttpServletRequest s) {
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Error.response(defaultMessage, HttpStatus.BAD_REQUEST, s.getRequestURI());
    }

}
