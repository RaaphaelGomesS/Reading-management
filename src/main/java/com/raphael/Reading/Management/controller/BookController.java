package com.raphael.Reading.Management.controller;

import com.raphael.Reading.Management.dto.BookRequestDTO;
import lombok.AllArgsConstructor;
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

    @PostMapping("/create")
    public ResponseEntity<Void> createBook(@RequestBody BookRequestDTO book, @RequestHeader(name = "Authorization") String token) {


    }
}
