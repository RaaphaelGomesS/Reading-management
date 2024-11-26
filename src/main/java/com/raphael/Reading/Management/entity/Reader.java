package com.raphael.Reading.Management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reader")
@EqualsAndHashCode(of = {"readerId"})
public class Reader {

    @Id
    @Column(name = "reader_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long readerId;

    @Column(name = "name")
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonBackReference
    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
    private List<Book> books;
}
