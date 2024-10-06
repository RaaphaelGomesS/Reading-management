package com.raphael.ReadingManagement.entities;

import com.raphael.ReadingManagement.indicator.StatusIndicator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    private Long BookId;

    @Column(name = "library_id")
    private Long LibraryId;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author_name")
    private String author;

    @Column(name = "publisher_name")
    private String publisher;

    @Column(name = "total_pages")
    private int totalPages;

    @Column(name = "pages_read")
    private int pagesRead;

    @Column(name = "status")
    private StatusIndicator status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
