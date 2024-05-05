package com.ms.user.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserRequestDto(

        @NotNull(message = "o campo name não pode ser nulo.")
        @NotBlank(message = "o campo name não pode estar em branco.")
        String name,

        @NotNull(message = "o campo email não pode ser nulo")
        @NotBlank(message = "o campo email não pode estar em branco.")
        @Email(message = "insira um email válido." )
        String email
) {}
