package com.libraryApi.dto;


import com.libraryApi.Enum.BookGenre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private Long id;
    private String title;
    private String authors;
    private String edition;
    private BookGenre genre;

    public BookDTO(Long id, String title, String authors, String edition, BookGenre genre) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.edition = edition;
        this.genre = genre;
    }
}
