package pl.coderslab.app.domain.dao;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.domain.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    protected EntityManager em;

    public void save(Publisher entity) {
        em.persist(entity);
    }

    public Publisher update(Publisher entity){
        return em.merge(entity);
    }

    public Publisher findById(Long id){
        return em.find(Publisher.class, id);
    }

    public void remove(Publisher entity){
        em.remove((em.contains(entity))?entity: em.merge(entity));
    }

    public List<Publisher> findAll(){
        return em.createQuery("SELECT p FROM Publisher p", Publisher.class).getResultList();
    }
}
