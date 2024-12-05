package com.raphael.Reading.Management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "annotation")
@EqualsAndHashCode(of = {"annotationId"})
public class Annotation {

    @Id
    @Column(name = "annotation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long annotationId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    private Book book;

    @Column(name = "book_id", nullable = false, insertable = false, updatable = false)
    private long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "desc", nullable = false)
    private String description;
}
