package com.raphael.ReadingManagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class LibraryResponseDTO {

    private String name;

    private List<BookResponseDTO> bookList;
}
