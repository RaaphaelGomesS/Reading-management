package com.raphael.Reading.Management.repository;

import com.raphael.Reading.Management.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Reader findByUsername(String username);

    Optional<Reader> findReaderByUsername(String username);
}
