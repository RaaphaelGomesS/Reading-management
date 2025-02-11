package com.raphael.Reading.Management.builder;

import com.raphael.Reading.Management.dto.BookResponseDTO;
import com.raphael.Reading.Management.model.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookResponseDTOBuilder {

    public static BookResponseDTO from(Book book) {
        return BookResponseDTO.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .totalPages(book.getTotalPages())
                .status(book.getStatus().name())
                .build();
    }
}
