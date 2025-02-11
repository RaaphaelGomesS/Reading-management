package com.raphael.Reading.Management.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.raphael.Reading.Management.model.Reader;
import com.raphael.Reading.Management.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    @Value("${token.secret}")
    private String secret;

    private final ReaderRepository readerRepository;

    private final Instant EXPIRE = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

    public String generateToken(Reader reader) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("Reading-management")
                    .withSubject(reader.getUsername())
                    .withExpiresAt(EXPIRE)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    public Reader getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            String username = JWT.require(algorithm)
                    .withIssuer("Reading-management")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

            return loadUserByUsername(username);
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    @Override
    public Reader loadUserByUsername(String username) throws UsernameNotFoundException {
        return readerRepository.findByUsername(username);
    }
}
