package com.raphael.Reading.Management.controller;

import com.raphael.Reading.Management.dto.LoginRequest;
import com.raphael.Reading.Management.dto.ReaderDTO;
import com.raphael.Reading.Management.dto.ReaderDTORequest;
import com.raphael.Reading.Management.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {

    private AuthenticationService service;

    @PostMapping("/create")
    public ResponseEntity<ReaderDTO> createAccount(@RequestBody @Valid ReaderDTORequest request) {

        ReaderDTO readerDTO = service.createReader(request);

        return ResponseEntity.ok(readerDTO);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
//
//    }
}
