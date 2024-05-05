package com.ms.user.producers;

import com.ms.user.models.dto.request.EmailRequestDto;
import com.ms.user.models.dto.response.UserResponse;
import com.ms.user.utils.Reader;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    @SuppressWarnings("unused")
    @Value("${spring.rabbitmq.template.queue}")
    private String queue;

    private final RabbitTemplate rabbitTemplate;

    public void publishMessageEmail(UserResponse userResponse){
        var email = EmailRequestDto.builder()
                .emailTo(userResponse.email())
                .userId(userResponse.id())
                .subject("Cadastro realizado com sucesso!")
                .text(String.format(Reader.getContentFile("message.txt"), userResponse.name()))
                .build();
        rabbitTemplate.convertAndSend("", queue, email);
    }

}
