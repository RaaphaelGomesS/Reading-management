package com.raphael.ReadingManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id", nullable = false, updatable = false)
    private Long ratingId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "rate")
    private int rate;

    @Column(name = "favorite")
    private boolean favorite;

    @JsonManagedReference
    @OneToMany(mappedBy = "rating", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RatingDescription> ratingDescriptions;
}
