package com.libraryApi.model;

import com.libraryApi.Enum.BookGenre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "authors" ,nullable = false)
    private String authors;

    @Column(name = "edition" , nullable = false)
    private String edition;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre" , nullable = false)
    private BookGenre genre;

}