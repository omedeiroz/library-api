package com.libraryApi.service;

import com.libraryApi.Enum.BookGenre;
import com.libraryApi.model.Book;
import com.libraryApi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    public List<Book> getBooksByGenre(BookGenre genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepository.findByAuthorsContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }
}
