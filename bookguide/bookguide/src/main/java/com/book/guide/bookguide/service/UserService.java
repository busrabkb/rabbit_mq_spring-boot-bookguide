package com.book.guide.bookguide.service;

import com.book.guide.bookguide.dto.UserDTO;
import com.book.guide.bookguide.producer.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserProducer userProducer;

    public void processUser(UserDTO userDTO) {
        userProducer.sendUser(userDTO);
    }
}
