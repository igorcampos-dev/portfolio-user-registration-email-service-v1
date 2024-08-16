package com.ms.email.services;

import com.ms.email.exceptions.EmailException;
import com.ms.email.mapper.EmailMapper;
import com.ms.email.models.dto.request.EmailRequestDto;
import com.ms.email.repositories.EmailRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final EmailRepository emailRepository;

    @Override
    public void sendSimpleMessage(EmailRequestDto dto) {
        this.sendEmail(dto);
        this.save(dto);
    }

    private void save(EmailRequestDto dto){
        var userMapper = EmailMapper.dtoToEntity(dto);
        emailRepository.save(userMapper);
    }

    private void sendEmail(EmailRequestDto dto){
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(dto.emailTo());
            helper.setSubject(dto.subject());
            helper.setText(dto.text(), true);
            emailSender.send(message);
        } catch (Exception e) {
            throw new EmailException(String.format("Houve um erro ao enviar o email: %s", e.getMessage()));
        }
    }
    
}

