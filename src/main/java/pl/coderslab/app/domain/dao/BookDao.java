package pl.coderslab.app.domain.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.domain.model.Author;
import pl.coderslab.app.domain.model.Book;
import pl.coderslab.app.domain.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    protected EntityManager em;

    public void save(Book entity) {
        em.persist(entity);
    }

    public Book update(Book entity) {
        return em.merge(entity);
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public void remove(Book entity) {
        em.remove((em.contains(entity) ? entity : em.merge(entity)));
    }

    public List<Book> findAll() {
        return em.createQuery("SELECT b from Book b", Book.class).getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return em.createQuery("SELECT x FROM Book x WHERE x.rating = :rating", Book.class)
                .setParameter("rating", rating)
                .getResultList();
    }

    public List<Book> findAllByPublisher() {
        return em.createQuery("SELECT b FROM Book b JOIN b.publisher", Book.class).getResultList();
    }

    public List<Book> findAllByPublisherIsNotNull(){
        return em.createQuery("SELECT b FROM Book b WHERE b.publisher IS NOT NULL", Book.class).getResultList();
    }

    public List <Book> findAllByPublisher(Publisher publisher){
        return em.createQuery("SELECT b FROM Book b where b.publisher = :publisher", Book.class)
                .setParameter("publisher", publisher)
                .getResultList();
    }

    public List <Book> findAllByPublisher(Long publisherId){
        return em.createQuery("SELECT b FROM Book b where b.publisher.id = :publisherId",Book.class)
                .setParameter("publisherId", publisherId)
                .getResultList();
    }

    public List<Book> findAllByAuthor(Author author){
        return em.createQuery("SELECT b FROM Book b join fetch b.authors where :author member b.authors", Book.class)
                .setParameter("author", author)
                .getResultList();
    }

    public Book findWithPublishersById(Long id) {
        Book book = findById(id);
        if (book != null) {
            //Pobieramy z bazy danę autorów dla wskazanej książki
            //alternatywnie możemy dostarczyć zapytanie, które pobiera książkę z autorami
            //w jednym odpytaniu bazy
            Hibernate.initialize(book.getAuthors());
        }
        return book;
    }

    public List<Book> findAllWithAuthors() {
        return em.createQuery("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.authors", Book.class).getResultList();
    }
}
