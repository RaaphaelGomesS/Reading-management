package com.raphael.Reading.Management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.raphael.Reading.Management.indicator.ReadingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
@EqualsAndHashCode(of = {"bookId"})
public class Book {

    @Id
    @Column(name = "book_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "reader_id", referencedColumnName = "reader_id", nullable = false)
    private Reader reader;

    @Column(name = "reader_id", nullable = false, insertable = false, updatable = false)
    private long readerId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "total_pages", nullable = false)
    private int totalPages;

    @Column(name = "read_pages")
    private int readPages;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ReadingStatus status;

    @Column(name = "rate")
    private int rate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @JsonBackReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Annotation> annotations;
}
