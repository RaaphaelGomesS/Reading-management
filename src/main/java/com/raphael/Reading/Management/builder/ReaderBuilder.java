package com.raphael.Reading.Management.builder;


import com.raphael.Reading.Management.dto.ReaderRequestDTO;
import com.raphael.Reading.Management.entity.Reader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ReaderBuilder {

    public static Reader from(ReaderRequestDTO request, PasswordEncoder passwordEncoder) {
        return Reader.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .books(new ArrayList<>())
                .build();
    }
}
