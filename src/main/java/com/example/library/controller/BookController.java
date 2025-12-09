package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        book.setId(id);
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchByAuthor(@RequestParam String author) {
        if (author == null || author.trim().isEmpty()) {
            return bookService.getAllBooks();
        }
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/filter")
    public List<Book> filterByGenre(@RequestParam String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            return bookService.getAllBooks();
        }
        return bookService.filterByGenre(genre);
    }
}