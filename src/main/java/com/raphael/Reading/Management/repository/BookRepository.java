package com.raphael.Reading.Management.repository;

import com.raphael.Reading.Management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM book b WHERE b.title = :title AND b.author_name = :author_name")
    Optional<Book> findBookByTitleAndAuthorName(@Param("title") String title, @Param("author_name") String authorName);
}
