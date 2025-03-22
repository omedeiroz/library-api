package com.libraryApi.service;

import com.libraryApi.Enum.BookGenre;
import com.libraryApi.dto.BookDTO;
import com.libraryApi.model.Book;
import com.libraryApi.repository.BookRepository;
import org.springframework.beans.BeanUtils;
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

    public Book saveBook(BookDTO book) {
        Book bookSave = new Book();
        BeanUtils.copyProperties(book , bookSave, "id");
        return bookRepository.save(bookSave);
    }

    public Book deleteBook(Long id) {
        Book bookReturn = bookRepository.findById(id).orElse(null);
        bookRepository.deleteById(id);
        return bookReturn;
    }

    public Book updateBook(Long id, BookDTO book) {
        var bookUpdate = getBookById(id).orElseThrow();
        BeanUtils.copyProperties(book , bookUpdate, "id");
        return bookRepository.save(bookUpdate);
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
