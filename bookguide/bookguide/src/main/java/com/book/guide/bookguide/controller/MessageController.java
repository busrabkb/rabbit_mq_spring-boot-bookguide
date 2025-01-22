package com.book.guide.bookguide.controller;

import com.book.guide.bookguide.dto.BookDTO;
import com.book.guide.bookguide.dto.UserDTO;
import com.book.guide.bookguide.producer.BookProducer;
import com.book.guide.bookguide.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MessageController {

    private final BookProducer bookProducer;


    private final UserService userService;

    @PostMapping("/user")
    public void sendUser(@RequestBody UserDTO userDTO) {
        userService.processUser(userDTO);
    }
    @PostMapping("/book")
    public void sendBook(@RequestBody BookDTO bookDTO) {
        bookProducer.sendBook(bookDTO);
    }

}
