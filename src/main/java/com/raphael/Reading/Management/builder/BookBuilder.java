package com.raphael.Reading.Management.builder;

import com.raphael.Reading.Management.dto.BookRequestDTO;
import com.raphael.Reading.Management.indicator.ReadingStatus;
import com.raphael.Reading.Management.model.Book;
import com.raphael.Reading.Management.model.Reader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookBuilder {

    public static Book from(BookRequestDTO requestDTO, Reader reader, ReadingStatus status) {
        return Book.builder()
                .title(requestDTO.title())
                .authorName(requestDTO.authorName())
                .reader(reader)
                .readerId(reader.getReaderId())
                .totalPages(requestDTO.totalPages())
                .status(status)
                .annotations(new ArrayList<>())
                .build();
    }

    public static Book editFrom(Book book, BookRequestDTO requestDTO, ReadingStatus status) {

        book.setTitle(requestDTO.title());
        book.setAuthorName(requestDTO.authorName());
        book.setTotalPages(requestDTO.totalPages());
        book.setStatus(status);

        return book;
    }
}
