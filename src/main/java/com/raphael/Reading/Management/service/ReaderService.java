package com.raphael.Reading.Management.service;

import com.raphael.Reading.Management.builder.ReaderBuilder;
import com.raphael.Reading.Management.dto.ReaderDTO;
import com.raphael.Reading.Management.dto.ReaderDTORequest;
import com.raphael.Reading.Management.entity.Reader;
import com.raphael.Reading.Management.exception.ReaderException;
import com.raphael.Reading.Management.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ReaderDTO createReader(ReaderDTORequest request) {

        Optional<Reader> optionalReader = readerRepository.findReaderByUsername(request.username());

        if (optionalReader.isPresent()) {
            throw new ReaderException("Usuário já registrado!", HttpStatus.BAD_REQUEST);
        }

        Reader reader = ReaderBuilder.from(request, passwordEncoder);

        readerRepository.save(reader);

        return new ReaderDTO(reader.getName(), reader.getUsername());
    }
}
