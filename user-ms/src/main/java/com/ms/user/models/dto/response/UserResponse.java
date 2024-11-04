package com.ms.user.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import java.util.UUID;

@Builder
public record UserResponse(

        @Schema(name = "id", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6", requiredMode = Schema.RequiredMode.REQUIRED, description = "Id único do usuário cadastrado ", type = "String")
        @NotNull(message = "o campo id não pode ser nulo.")
        @NotBlank(message = "o campo id não pode estar em branco.")
        UUID id,

        @Schema(name = "name", example = "name", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do usuário cadastrado ", type = "String")
        @NotNull(message = "o campo name não pode ser nulo.")
        @NotBlank(message = "o campo name não pode estar em branco.")
        String name,

        @Schema(name = "email", example = "example@example.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "Email usuário cadastrado", type = "String")
        @NotNull(message = "o campo email não pode ser nulo")
        @NotBlank(message = "o campo email não pode estar em branco.")
        @Email(message = "insira um email válido." )
        String email
) {}
