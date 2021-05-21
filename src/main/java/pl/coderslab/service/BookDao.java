package pl.coderslab.service;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BookDao  {

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }



    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }


    public void update(Book book) {
        entityManager.merge(book);
    }


    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book)); }


    public Book findBookWithAuthorsById(Long id) {
        Book book = findById(id);
        Hibernate.initialize(book.getPublishers());
        return book;
    }

    public List<Book> findAll(){
        Query query = entityManager.createQuery("SELECT book FROM Book book");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating){
        Query query = entityManager.createQuery("SELECT book FROM Book book WHERE book.rating > :rating");
        query.setParameter("rating", rating);         //Ustawiamy wartość zmiennej określonej w zapytaniu.
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> findAllBooksWithEnyPublisher(){
        Query query = entityManager.createQuery("SELECT book FROM Book book JOIN book.publishers");
        return query.getResultList();
    }

    public List<Book> findAllBooksWithThisPublisher(Publisher publisher){
        Long publisherId = publisher.getId();
        Query query = entityManager.createQuery("SELECT book FROM Book book JOIN book.publishers WHERE publisherId");
        return query.getResultList();
    }


    public List<Book> findAllBooksWithThisAuthor(Author author){
        Long authorId = author.getId();
        Query query = entityManager.createQuery("SELECT book FROM Book book JOIN book.publishers WHERE authorId");
        return query.getResultList();
    }

}
