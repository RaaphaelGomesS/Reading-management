package com.raphael.ReadingManagement.repository;

import com.raphael.ReadingManagement.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    @Query("SELECT l FROM library l WHERE l.library_name = :name")
    Optional<Library> findByName(@Param("name") String name);

    @Query("SELECT l FROM library l WHERE l.library_name = :name AND l.reader_id = :readerId")
    Optional<Library> findByNameToAccount(@Param("name") String name, @Param("reader_id") Long readerId);
}
