package com.ms.email.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import java.util.UUID;

@Builder
public record EmailRequestDto(
        @NotNull(message = "o campo userId não pode ser nulo.")
        @NotBlank(message = "o campo userId não pode estar em branco.")
        UUID userId,

        @NotNull(message = "o campo emailTo não pode ser nulo.")
        @NotBlank(message = "o campo emailTo não pode estar em branco.")
        String emailTo,

        @NotNull(message = "o campo subject não pode ser nulo.")
        @NotBlank(message = "o campo subject não pode estar em branco.")
        String subject,

        @NotNull(message = "o campo text não pode ser nulo.")
        @NotBlank(message = "o campo text não pode estar em branco.")
        String text
) {}
