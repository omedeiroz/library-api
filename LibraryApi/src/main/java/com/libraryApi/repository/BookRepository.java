package com.libraryApi.repository;


import com.libraryApi.Enum.BookGenre;
import com.libraryApi.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenre(BookGenre genre);

    List<Book> findByAuthorsContaining(String authorName);

    List<Book> findByTitleContaining(String title);

}
