package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    // Пошук за автором — частковий, без регістру (вже працював добре)
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Пошук за жанром — справжній частковий пошук по всьому полю genre
    @Query("{'genre': { $regex: ?0, $options: 'i' }}")
    List<Book> findByGenreRegex(String genre);
}