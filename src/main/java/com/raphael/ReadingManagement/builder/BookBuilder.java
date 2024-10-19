package com.raphael.ReadingManagement.builder;

import com.raphael.ReadingManagement.dto.BookRequestDTO;
import com.raphael.ReadingManagement.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookBuilder {

    public static Book from(BookRequestDTO requestDTO) {

        return Book.builder().build();
    }
}
