package com.raphael.Reading.Management.service;

import com.raphael.Reading.Management.builder.ReaderBuilder;
import com.raphael.Reading.Management.dto.ReaderDTO;
import com.raphael.Reading.Management.dto.ReaderDTORequest;
import com.raphael.Reading.Management.entity.Reader;
import com.raphael.Reading.Management.exception.ReaderException;
import com.raphael.Reading.Management.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private ReaderRepository readerRepository;

    public ReaderDTO createReader(ReaderDTORequest request) {

        UserDetails userDetails = loadUserByUsername(request.username());

        if (userDetails != null) {
            throw new ReaderException("Usuário já registrado!", HttpStatus.BAD_REQUEST);
        }

        Reader reader = ReaderBuilder.from(request);

        readerRepository.save(reader);

        return new ReaderDTO(reader.getName(), reader.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return readerRepository.findByUsername(username);
    }
}
