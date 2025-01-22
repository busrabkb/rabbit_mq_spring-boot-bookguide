package com.book.guide.bookguide.consumer;

import com.book.guide.bookguide.dto.BookDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BookConsumer {

    @RabbitListener(queues = "bookQueue")
    public void receiveBook(BookDTO bookDTO) {

        System.out.println("Received Book: " + bookDTO.getTitle());
    }
}