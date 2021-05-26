package pl.coderslab.app.domain.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.domain.model.Book;

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

    public List<Book> findAll(){
        return em.createQuery("SELECT b from Book b", Book.class).getResultList();
    }
}
