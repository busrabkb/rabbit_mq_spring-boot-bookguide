package com.book.guide.bookguide;
import com.book.guide.bookguide.dto.BookDTO;
import com.book.guide.bookguide.producer.BookProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AmqpTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookProducerTest {

    @Mock
    private AmqpTemplate amqpTemplate;

    @InjectMocks
    private BookProducer bookProducer;

    @Test
    public void testSendBook() {
        //given
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Spring Boot");
        bookDTO.setAuthor("John Doe");

        //when
        bookProducer.sendBook(bookDTO);

        //then
        verify(amqpTemplate).convertAndSend("bookQueue", bookDTO);
    }
}
