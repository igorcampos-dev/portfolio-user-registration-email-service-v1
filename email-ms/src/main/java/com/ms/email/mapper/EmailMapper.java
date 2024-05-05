package com.ms.email.mapper;

import com.ms.email.models.dto.request.EmailRequestDto;
import com.ms.email.models.entity.EmailEntity;
import com.ms.email.models.entity.enums.StatusEmail;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class EmailMapper {

    public static EmailEntity dtoToEntity(EmailRequestDto dto){
        return EmailEntity.builder()
                .userId(dto.userId())
                .emailFrom("WE")
                .emailTo(dto.emailTo())
                .subject(dto.subject())
                .text(dto.text())
                .sendDateEmail(LocalDateTime.now())
                .statusEmail(StatusEmail.SENT)
                .build();
    }
}
