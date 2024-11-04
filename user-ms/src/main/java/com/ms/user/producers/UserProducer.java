package com.ms.user.producers;

import com.ms.user.models.dto.request.EmailRequestDto;
import com.ms.user.models.dto.response.UserResponse;
import io.github.springwolf.bindings.amqp.annotations.AmqpAsyncOperationBinding;
import io.github.springwolf.core.asyncapi.annotations.AsyncMessage;
import io.github.springwolf.core.asyncapi.annotations.AsyncOperation;
import io.github.springwolf.core.asyncapi.annotations.AsyncPublisher;
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

    @AsyncPublisher(
            operation =
            @AsyncOperation(
                    message = @AsyncMessage(
                            name = "userResponse",
                            contentType = "application/json",
                            description = "The sending body has registration information indicating which user registered"
                    ),
                    headers = @AsyncOperation.Headers(
                            notUsed = true
                    ),
                    payloadType = UserResponse.class,
                    channelName = "",
                    description = "Producer responsible for sending user registration messages to the mail queue"
            )
    )
    @AmqpAsyncOperationBinding()
    public void publishMessageEmail(UserResponse userResponse){
        var email = EmailRequestDto.toEmailRequestDto(userResponse);
        rabbitTemplate.convertAndSend("", queue, email);
    }

}
