package com.book.guide.bookguide.consumer;

import com.book.guide.bookguide.dto.UserDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @RabbitListener(queues = "userQueue")
    public void receiveUser(UserDTO userDTO) {

        System.out.println("Received User: " + userDTO.getName());
    }
}