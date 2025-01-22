package com.book.guide.bookguide.producer;

import com.book.guide.bookguide.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookProducer {


    private final AmqpTemplate amqpTemplate;

    public void sendBook(BookDTO bookDTO) {
        amqpTemplate.convertAndSend("bookQueue", bookDTO);
    }
}