package com.raphael.Reading.Management.dto;

import jakarta.validation.constraints.NotBlank;

public record BookRequestDTO(@NotBlank(message = "O título não pode estar em branco.") String title,
                             @NotBlank(message = "O nome do autor não pode estar em branco.") String authorName,
                             @NotBlank(message = "A quantidade de páginas totais não pode estar em branco.") int totalPages,
                             int readPages,
                             long id,
                             String status) {
}
