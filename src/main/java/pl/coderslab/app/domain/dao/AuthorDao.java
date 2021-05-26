package pl.coderslab.app.domain.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.domain.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    protected EntityManager em;

    public void save(Author entity) {
        em.persist(entity);
    }


    public Author update(Author entity) {
        return em.merge(entity);
    }

    public Author findById(Long id) {
        return em.find(Author.class, id);
    }

    public void remove(Author entity) {
        em.remove((em.contains(entity)) ? entity : em.merge(entity));
    }

    public List<Author> findAll() {
        return em.createQuery("select a from Author a", Author.class).getResultList();
    }
}
