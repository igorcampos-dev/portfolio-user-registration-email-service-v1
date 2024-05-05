package com.ms.email.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class RabbitMQConfig {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("${spring.rabbitmq.template.queue}")
    private String queue;

    @Bean
    public Queue queue (){
        return new Queue(queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
      return new Jackson2JsonMessageConverter(mapper);
    }
}
