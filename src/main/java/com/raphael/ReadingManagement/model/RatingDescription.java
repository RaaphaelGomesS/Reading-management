package com.raphael.ReadingManagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rating_description")
public class RatingDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_desc_id", nullable = false, updatable = false)
    private Long ratingDescId;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @Column(name = "rating_id", nullable = false)
    private Long ratingId;

    @Column(name = "chapter", nullable = false)
    private int chapter;

    @Column(name = "description")
    private String description;
}
