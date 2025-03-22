package com.libraryApi.dto;
import com.libraryApi.Enum.BookGenre;
import jakarta.validation.constraints.NotBlank;

public record BookDTO(Long id, @NotBlank String title, @NotBlank String authors, @NotBlank String edition, @NotBlank BookGenre genre ) {
}
