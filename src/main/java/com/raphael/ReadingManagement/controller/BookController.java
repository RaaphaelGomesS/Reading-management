package com.raphael.ReadingManagement.controller;

import com.raphael.ReadingManagement.dto.BookRequestDTO;
import com.raphael.ReadingManagement.model.Reader;
import com.raphael.ReadingManagement.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController(value = "/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> createBookAndIndexToLibrary(@RequestBody BookRequestDTO requestDTO, @RequestHeader String token) {

        Reader reader = new Reader();

        bookService.createBook(requestDTO, reader);

        return ResponseEntity.ok().build();
    }
}
