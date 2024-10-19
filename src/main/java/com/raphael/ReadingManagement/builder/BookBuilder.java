package com.raphael.ReadingManagement.builder;

import com.raphael.ReadingManagement.dto.BookRequestDTO;
import com.raphael.ReadingManagement.model.Book;
import com.raphael.ReadingManagement.model.Library;
import org.springframework.stereotype.Component;

@Component
public class BookBuilder {

    public static Book from(BookRequestDTO requestDTO, Library library) {

        return Book.builder().build();
    }
}
