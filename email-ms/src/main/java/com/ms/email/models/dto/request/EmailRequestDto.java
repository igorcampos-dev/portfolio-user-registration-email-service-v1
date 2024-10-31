package com.ms.email.models.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.email.models.entity.enums.StatusEmail;
import io.swagger.v3.oas.annotations.media.Schema;
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

        @Schema(name = "userId", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6", requiredMode = Schema.RequiredMode.REQUIRED, description = "id", type = "UUID")
        @NotNull(message = "o campo userId não pode ser nulo.")
        @NotBlank(message = "o campo userId não pode estar em branco.")
        private UUID userId;

        @Schema(name = "emailTo", example = "example@example.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "email", type = "String")
        @NotNull(message = "o campo emailTo não pode ser nulo.")
        @NotBlank(message = "o campo emailTo não pode estar em branco.")
        private String emailTo;

        @Schema(name = "subject", example = "subject", requiredMode = Schema.RequiredMode.REQUIRED, description = "subject", type = "String")
        @NotNull(message = "o campo subject não pode ser nulo.")
        @NotBlank(message = "o campo subject não pode estar em branco.")
        private String subject;

        @Schema(name = "text", example = "text", requiredMode = Schema.RequiredMode.REQUIRED, description = "text", type = "String")
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
