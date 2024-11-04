package com.ms.user.models.dto.request;

import com.ms.user.models.dto.response.UserResponse;
import com.ms.user.utils.ReaderUtil;
import jakarta.validation.constraints.Email;
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
        @Email(message = "insira um email válido.")
        String emailTo,

        @NotNull(message = "o campo subject não pode ser nulo.")
        @NotBlank(message = "o campo subject não pode estar em branco.")
        String subject,

        @NotNull(message = "o campo text não pode ser nulo.")
        @NotBlank(message = "o campo text não pode estar em branco.")
        String text
) {

        public static EmailRequestDto toEmailRequestDto(UserResponse userResponse){
                return EmailRequestDto
                        .builder()
                        .emailTo(userResponse.email())
                        .userId(userResponse.id())
                        .subject("Cadastro realizado com sucesso!")
                        .text(String.format(ReaderUtil.getContentFile("message.txt"), userResponse.name()))
                        .build();
        }

}
