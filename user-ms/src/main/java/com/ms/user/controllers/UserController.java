package com.ms.user.controllers;

import com.ms.user.models.dto.request.UserRequestDto;
import com.ms.user.models.dto.response.UserResponse;
import com.ms.user.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = UserController.PATH)
@RequiredArgsConstructor
@Tag(name = "Salvar usuários", description = "Controlador para efetuar Salvar usuários")
public class UserController {

    public static final String PATH = "/v1/auth";
    private final UserService userService;

    @ApiResponse(description = "Salvar o usuário", responseCode = "200")
    @Operation(summary = "Salva o usuário no banco de dados", description = """
            # Salva o usuário no banco de dados e envia um email de boas vindas.
            ---
           
            """)
    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequestDto userRequestDto){
        log.info("Starting a user's registration process...");
        var response = userService.save(userRequestDto);
        log.info("Successfully completed user registration process.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
