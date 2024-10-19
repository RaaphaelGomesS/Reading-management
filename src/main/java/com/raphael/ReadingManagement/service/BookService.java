package com.raphael.ReadingManagement.service;

import com.raphael.ReadingManagement.builder.BookBuilder;
import com.raphael.ReadingManagement.dto.BookRequestDTO;
import com.raphael.ReadingManagement.exception.LibraryException;
import com.raphael.ReadingManagement.model.Book;
import com.raphael.ReadingManagement.model.Library;
import com.raphael.ReadingManagement.model.Reader;
import com.raphael.ReadingManagement.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final LibraryService libraryService;

    public void createBook(BookRequestDTO requestDTO, Reader reader) {

        Library library = libraryService.getLibrary(requestDTO.getLibraryName(), reader.getReaderId());

        Book newBook = BookBuilder.from(requestDTO, library);

        if (library.getBooks().stream().anyMatch(book -> book.getName().equals(newBook.getName()))) {
            throw new LibraryException("O livro já foi cadastrado nessa biblioteca", HttpStatus.BAD_REQUEST);
        }

        bookRepository.save(newBook);
    }
}
