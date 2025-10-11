package org.example.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UpdateUserRecord(
        @NotBlank(message = "Name is mandatory")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name
) {
}
