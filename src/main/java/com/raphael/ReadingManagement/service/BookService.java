package com.raphael.ReadingManagement.service;

import com.raphael.ReadingManagement.builder.BookBuilder;
import com.raphael.ReadingManagement.dto.BookRequestDTO;
import com.raphael.ReadingManagement.model.Book;
import com.raphael.ReadingManagement.repository.BookRepository;
import lombok.AllArgsConstructor;
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
