package com.raphael.Reading.Management.service;

import com.raphael.Reading.Management.builder.ReaderBuilder;
import com.raphael.Reading.Management.dto.ReaderDTO;
import com.raphael.Reading.Management.dto.ReaderRequestDTO;
import com.raphael.Reading.Management.model.Reader;
import com.raphael.Reading.Management.exception.ReaderException;
import com.raphael.Reading.Management.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    private final PasswordEncoder passwordEncoder;

    public ReaderDTO createReader(ReaderRequestDTO request) {

        Optional<Reader> optionalReader = readerRepository.findReaderByUsername(request.username());

        if (optionalReader.isPresent()) {
            throw new ReaderException("Usuário já registrado!", HttpStatus.BAD_REQUEST);
        }

        Reader reader = ReaderBuilder.from(request, passwordEncoder);

        readerRepository.save(reader);

        return new ReaderDTO(reader.getName(), reader.getUsername());
    }
}
