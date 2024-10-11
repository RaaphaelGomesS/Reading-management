package com.raphael.ReadingManagement.service;

import com.raphael.ReadingManagement.BookBuilder;
import com.raphael.ReadingManagement.dto.BookRequestDTO;
import com.raphael.ReadingManagement.exception.LibraryException;
import com.raphael.ReadingManagement.model.Book;
import com.raphael.ReadingManagement.model.Library;
import com.raphael.ReadingManagement.repository.BookRepository;
import com.raphael.ReadingManagement.repository.LibraryRepository;
import com.raphael.ReadingManagement.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final LibraryService libraryService;

    public void createBook(BookRequestDTO requestDTO) {

        Book book = BookBuilder.from(requestDTO);

        libraryService.addBook(requestDTO.getLibraryName(), book);

        bookRepository.save(book);
    }


}
