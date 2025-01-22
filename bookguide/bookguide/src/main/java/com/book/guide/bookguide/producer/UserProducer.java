package com.book.guide.bookguide.producer;

import com.book.guide.bookguide.dto.UserDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendUser(UserDTO userDTO) {
        amqpTemplate.convertAndSend("userQueue", userDTO);
    }
}