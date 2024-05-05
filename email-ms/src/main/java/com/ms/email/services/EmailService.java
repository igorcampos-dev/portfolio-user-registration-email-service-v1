package com.ms.email.services;

import com.ms.email.models.dto.request.EmailRequestDto;

public interface EmailService {
    void sendSimpleMessage(EmailRequestDto dto);
}
