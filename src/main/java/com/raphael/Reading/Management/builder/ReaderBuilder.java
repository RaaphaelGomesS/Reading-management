package com.raphael.Reading.Management.builder;


import com.raphael.Reading.Management.dto.ReaderRequestDTO;
import com.raphael.Reading.Management.model.Reader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
