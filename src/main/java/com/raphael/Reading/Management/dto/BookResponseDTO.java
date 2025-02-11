package com.raphael.Reading.Management.dto;

import lombok.Builder;

@Builder
public record BookResponseDTO(long bookId,
                              String title,
                              String authorName,
                              int totalPages,
                              String status) {
}
