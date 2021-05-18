package pl.coderslab.service;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;


@Repository
@Transactional
public class BookDao  {

//    private final List<Book> books = new ArrayList<>();

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }


//    @Override
//    public Optional<Book> findById(long id) {
//        return Optional.ofNullable(books.get(id));
//    }


    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }


    public void update(Book book) {
        entityManager.merge(book);
    }


    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book)); }
}
