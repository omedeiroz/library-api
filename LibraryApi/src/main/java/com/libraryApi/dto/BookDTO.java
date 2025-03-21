package com.libraryApi.dto;
import com.libraryApi.Enum.BookGenre;

public record BookDTO(Long id, String title, String authors, String edition, BookGenre genre ) {
}
