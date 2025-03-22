package com.libraryApi.controller;

import com.libraryApi.Enum.BookGenre;
import com.libraryApi.dto.BookDTO;
import com.libraryApi.model.Book;
import com.libraryApi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping   
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDTO book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.saveBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long id, @RequestBody BookDTO book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id,book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.deleteBook(id));
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestBody BookGenre genre) {
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.getBooksByGenre(genre));
    }

    @GetMapping("/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestBody String author) {
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/title")
    public ResponseEntity<List<Book>> getBooksByTitle(@RequestBody String title) {
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.getBooksByTitle(title));
    }
}
