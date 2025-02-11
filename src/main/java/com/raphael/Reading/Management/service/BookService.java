package com.raphael.Reading.Management.service;

import com.raphael.Reading.Management.builder.BookBuilder;
import com.raphael.Reading.Management.builder.BookResponseDTOBuilder;
import com.raphael.Reading.Management.dto.BookRequestDTO;
import com.raphael.Reading.Management.dto.BookResponseDTO;
import com.raphael.Reading.Management.exception.BookException;
import com.raphael.Reading.Management.indicator.ReadingStatus;
import com.raphael.Reading.Management.model.Book;
import com.raphael.Reading.Management.model.Reader;
import com.raphael.Reading.Management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookResponseDTO createBook(BookRequestDTO requestDTO, Reader reader) {

        validateWithAlreadyExist(requestDTO);

        Book book = BookBuilder.from(requestDTO, reader, ReadingStatus.A_LER);

        bookRepository.save(book);

        return BookResponseDTOBuilder.from(book);
    }

    private void validateWithAlreadyExist(BookRequestDTO requestDTO) {

        Optional<Book> optionalBook = bookRepository.findBookByTitleAndAuthorName(requestDTO.title(), requestDTO.authorName());

        if (optionalBook.isPresent()) {
            throw new BookException("Book already register!", HttpStatus.BAD_REQUEST);
        }
    }
}

