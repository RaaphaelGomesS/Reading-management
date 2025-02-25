package com.raphael.Reading.Management.controller;

import com.raphael.Reading.Management.dto.BookRequestDTO;
import com.raphael.Reading.Management.dto.BookResponseDTO;
import com.raphael.Reading.Management.model.Reader;
import com.raphael.Reading.Management.service.AuthenticationService;
import com.raphael.Reading.Management.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
@RestController("/book")
public class BookController {

    private final AuthenticationService authenticationService;

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO book, @RequestHeader(name = "Authorization") String token) {

        Reader reader = authenticationService.getSubject(token);

        return new ResponseEntity<>(bookService.createBook(book, reader), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<BookResponseDTO> updateBook(@RequestBody BookRequestDTO book, @RequestHeader(name = "Authorization") String token) {

        Reader reader = authenticationService.getSubject(token);

        return new ResponseEntity<>(bookService.editBook(book, reader), HttpStatus.CREATED);
    }
}
