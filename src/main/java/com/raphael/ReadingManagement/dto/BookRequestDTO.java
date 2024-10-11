package com.raphael.ReadingManagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class BookRequestDTO {

    private String libraryName;

    private String name;

    private String author;

    private String publisher;

    private int totalPages;

    private int pagesReade;
}
