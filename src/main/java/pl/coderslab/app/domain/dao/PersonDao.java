package pl.coderslab.app.domain.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.domain.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    protected EntityManager em;

    public void save(Person entity) {
        em.persist(entity);
    }


    public Person update(Person entity) {
        return em.merge(entity);
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public void remove(Person entity) {
        em.remove((em.contains(entity)) ? entity : em.merge(entity));
    }

    public List<Person> findAll() {
        return em.createQuery("select a from Person a", Person.class).getResultList();
    }
}
