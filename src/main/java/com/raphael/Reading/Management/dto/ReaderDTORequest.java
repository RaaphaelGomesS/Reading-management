package com.raphael.Reading.Management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ReaderDTORequest(String name,
                               @NotBlank(message = "O usuário não pode estar vazio.")
                               String username,
                               @NotBlank(message = "A senha não pode estar vazia.")
                               @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$" , message = "A senha deve ter no mínimo 8 dígitos, possuindo ao menos uma letra maiuscula, um número e um símbolo!")
                               String password) {
}
