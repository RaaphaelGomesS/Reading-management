package com.raphael.ReadingManagement.service;

import com.raphael.ReadingManagement.exception.LibraryException;
import com.raphael.ReadingManagement.model.Book;
import com.raphael.ReadingManagement.model.Library;
import com.raphael.ReadingManagement.model.Reader;
import com.raphael.ReadingManagement.repository.LibraryRepository;
import com.raphael.ReadingManagement.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryService {

    private final LibraryRepository repository;

    public void addBook(String name, Book newBook) {

        Library library = getLibraryByName(name);

        if (library.getBooks().stream().anyMatch(libraryBook -> libraryBook.getName().equalsIgnoreCase(newBook.getName()))) {
            throw new LibraryException("O livro já foi cadastrado nessa biblioteca", HttpStatus.BAD_REQUEST);
        }

        ValidationUtils.verifyHasPermission();
    }

    public Library getLibraryByName(String name) {

        if (name != null) {
            return repository.findByName(name).orElseThrow(() ->
                    new LibraryException("Nenhuma biblioteca com esse nome foi encontrada!", HttpStatus.NOT_FOUND));
        }

        throw new LibraryException("O nome da bibilioteca não foi informado!", HttpStatus.NOT_FOUND);
    }
}
