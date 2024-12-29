package com.raphael.Reading.Management.controller;

import com.raphael.Reading.Management.dto.LoginRequestDTO;
import com.raphael.Reading.Management.dto.ReaderDTO;
import com.raphael.Reading.Management.dto.ReaderRequestDTO;
import com.raphael.Reading.Management.entity.Reader;
import com.raphael.Reading.Management.service.AuthenticationService;
import com.raphael.Reading.Management.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationService service;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private ReaderService readerService;

    @PostMapping("/create")
    public ResponseEntity<ReaderDTO> createAccount(@RequestBody @Valid ReaderRequestDTO request) {

        ReaderDTO readerDTO = readerService.createReader(request);

        return ResponseEntity.ok(readerDTO);
    }

    @PostMapping("/")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {

        var authDTO = new UsernamePasswordAuthenticationToken(request.username(), request.password());

        var auth = manager.authenticate(authDTO);

        String token = service.generateToken((Reader) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }
}
