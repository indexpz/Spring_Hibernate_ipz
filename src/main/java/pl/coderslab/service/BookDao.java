package pl.coderslab.service;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


@Repository
@Transactional
public class BookDao implements BookService {

    private final Map<Long, Book> books = new LinkedHashMap<>();

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }


//    @Override
//    public Optional<Book> findById(long id) {
//        return Optional.ofNullable(books.get(id));
//    }

    @Override
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

@Override
    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book)); }
}
