package com.raphael.ReadingManagement.service;

import com.raphael.ReadingManagement.builder.BookBuilder;
import com.raphael.ReadingManagement.dto.BookRequestDTO;
import com.raphael.ReadingManagement.exception.LibraryException;
import com.raphael.ReadingManagement.model.Book;
import com.raphael.ReadingManagement.model.Library;
import com.raphael.ReadingManagement.model.Reader;
import com.raphael.ReadingManagement.repository.BookRepository;
import com.raphael.ReadingManagement.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final LibraryService libraryService;

    private final LibraryRepository libraryRepository;

    public void createBook(BookRequestDTO requestDTO, Reader reader) {

        Library library = libraryService.getLibrary(requestDTO.getLibraryName(), reader.getReaderId());

        Book book = BookBuilder.from(requestDTO, library);

        addBook(library, book);

        bookRepository.save(book);
    }

    private void addBook(Library library, Book newBook) {

        if (library.getBooks().stream().anyMatch(book -> book.getName().equals(newBook.getName()))) {
            throw new LibraryException("O livro já foi cadastrado nessa biblioteca", HttpStatus.BAD_REQUEST);
        }

        library.getBooks().add(newBook);

        libraryRepository.save(library);
    }
}
