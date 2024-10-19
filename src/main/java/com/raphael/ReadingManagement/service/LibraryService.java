package com.raphael.ReadingManagement.service;

import com.raphael.ReadingManagement.builder.LibraryBuilder;
import com.raphael.ReadingManagement.exception.LibraryException;
import com.raphael.ReadingManagement.model.Book;
import com.raphael.ReadingManagement.model.Library;
import com.raphael.ReadingManagement.model.Reader;
import com.raphael.ReadingManagement.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LibraryService {

    private final LibraryRepository repository;

    public Library createLibrary(String name, Reader reader) {

        Optional<Library> libraryOptional = repository.findByNameToAccount(name, reader.getReaderId());

        if (libraryOptional.isPresent()) {
            throw new LibraryException("Já existe uma biblioteca com esse nome!", HttpStatus.BAD_REQUEST);
        }

        Library newlibrary = LibraryBuilder.from(name, reader);

        return repository.save(newlibrary);
    }

//    public LibraryResponseDTO updateLibrary(LibraryRequestDTO requestDTO) {
//
//    }

    public void deleteLibrary(String name, Reader reader) {

        Library library = getLibrary(name, reader.getReaderId());

        repository.delete(library);
    }

    public Library getLibrary(String name, Long readerId) {

        if (name != null) {
            return repository.findByNameToAccount(name, readerId).orElseThrow(() ->
                    new LibraryException("Nenhuma biblioteca com esse nome foi encontrada!", HttpStatus.NOT_FOUND));
        }

        throw new LibraryException("O nome da bibilioteca não foi informado!", HttpStatus.NOT_FOUND);
    }
}
