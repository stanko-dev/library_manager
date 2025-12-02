package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByGenreIgnoreCase(String genre);
}