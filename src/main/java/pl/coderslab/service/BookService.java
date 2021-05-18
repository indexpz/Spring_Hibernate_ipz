package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.Optional;

public interface BookService {
    //    Optional<Book> findById(long id);

    Book findById(long id);

    void update(Book book);

    void delete(Book book);
}
