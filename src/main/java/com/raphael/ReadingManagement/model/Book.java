package com.raphael.ReadingManagement.model;

import com.raphael.ReadingManagement.indicator.StatusIndicator;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false, updatable = false)
    private Long BookId;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @Column(name = "library_id")
    private Long LibraryId;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author_name", nullable = false)
    private String author;

    @Column(name = "publisher_name", nullable = false)
    private String publisher;

    @Column(name = "total_pages", nullable = false)
    private int totalPages;

    @Column(name = "pages_read")
    private int pagesRead;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusIndicator status;

    @CreationTimestamp
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
