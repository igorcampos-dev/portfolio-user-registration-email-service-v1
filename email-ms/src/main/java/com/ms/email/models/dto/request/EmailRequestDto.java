package com.ms.email.models.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.email.models.entity.enums.StatusEmail;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequestDto{
        @NotNull(message = "o campo userId não pode ser nulo.")
        @NotBlank(message = "o campo userId não pode estar em branco.")
        private UUID userId;

        @NotNull(message = "o campo emailTo não pode ser nulo.")
        @NotBlank(message = "o campo emailTo não pode estar em branco.")
        private String emailTo;

        @NotNull(message = "o campo subject não pode ser nulo.")
        @NotBlank(message = "o campo subject não pode estar em branco.")
        private String subject;

        @NotNull(message = "o campo text não pode ser nulo.")
        @NotBlank(message = "o campo text não pode estar em branco.")
        private String text;

        @Nullable
        @JsonIgnore
        private LocalDateTime sendDateEmail;

        @Nullable
        @JsonIgnore
        private StatusEmail statusEmail;

        @Nullable
        @JsonIgnore
        private String emailFrom;


}
