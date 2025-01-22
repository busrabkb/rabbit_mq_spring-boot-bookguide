package com.book.guide.bookguide;



import com.book.guide.bookguide.consumer.BookConsumer;
import com.book.guide.bookguide.dto.BookDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookConsumerTest {

    @InjectMocks
    private BookConsumer bookConsumer;

    @Test
    public void testReceiveBook() {
        //given
        BookDTO bookDTO = mock(BookDTO.class);

        //when
        bookConsumer.receiveBook(bookDTO);

        //then
        verify(bookDTO).getTitle();
    }
}
