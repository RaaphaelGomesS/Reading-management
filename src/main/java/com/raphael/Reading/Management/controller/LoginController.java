package com.raphael.Reading.Management.controller;

import com.raphael.Reading.Management.dto.LoginRequest;
import com.raphael.Reading.Management.dto.ReaderDTO;
import com.raphael.Reading.Management.dto.ReaderDTORequest;
import com.raphael.Reading.Management.entity.Reader;
import com.raphael.Reading.Management.service.AuthenticationService;
import com.raphael.Reading.Management.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {

    private AuthenticationService service;

    private TokenService tokenService;

    private AuthenticationManager manager;

    @PostMapping("/create")
    public ResponseEntity<ReaderDTO> createAccount(@RequestBody @Valid ReaderDTORequest request) {

        ReaderDTO readerDTO = service.createReader(request);

        return ResponseEntity.ok(readerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        var authDTO = new UsernamePasswordAuthenticationToken(request.username(), request.password());

        var auth = manager.authenticate(authDTO);

        String token = tokenService.generateToken((Reader) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }
}
