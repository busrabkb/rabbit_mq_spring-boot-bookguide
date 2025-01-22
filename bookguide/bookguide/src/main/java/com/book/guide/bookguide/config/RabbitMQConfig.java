package com.book.guide.bookguide.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue bookQueue() {
        return new Queue("bookQueue", false);
    }

    @Bean
    public Queue userQueue() {
        return new Queue("userQueue", false);
    }
}