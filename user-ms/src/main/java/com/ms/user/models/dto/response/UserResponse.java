package com.ms.user.models.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import java.util.UUID;

@Builder
public record UserResponse(

        @NotNull(message = "o campo id não pode ser nulo.")
        @NotBlank(message = "o campo id não pode estar em branco.")
        UUID id,

        @NotNull(message = "o campo name não pode ser nulo.")
        @NotBlank(message = "o campo name não pode estar em branco.")
        String name,

        @NotNull(message = "o campo email não pode ser nulo")
        @NotBlank(message = "o campo email não pode estar em branco.")
        @Email(message = "insira um email válido." )
        String email
) {}
