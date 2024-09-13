package com.ms.email.services;

import com.ms.email.exceptions.EmailException;
import com.ms.email.mapper.EmailMapper;
import com.ms.email.models.dto.request.EmailRequestDto;
import com.ms.email.models.entity.enums.StatusEmail;
import com.ms.email.repositories.EmailRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;

    @Override
    public void sendSimpleMessage(EmailRequestDto dto) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(dto.getEmailTo());
            helper.setSubject(dto.getSubject());
            helper.setText(dto.getText(), true);
            emailSender.send(message);
            this.save(dto);
        } catch (Exception e) {
            throw new EmailException(String.format("Houve um erro ao enviar o email: %s", e.getMessage()));
        }
    }

    private void save(EmailRequestDto dto){

        dto.setEmailFrom("WE");
        dto.setSendDateEmail(LocalDateTime.now());
        dto.setStatusEmail(StatusEmail.SENT);

        emailRepository.save(emailMapper.toEntity(dto));
    }
    
}

