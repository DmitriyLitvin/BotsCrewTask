package mate.academy.jpademo.dao.impl;

import mate.academy.jpademo.dao.AbstractDao;
import mate.academy.jpademo.dao.LectorDao;
import mate.academy.jpademo.model.Lector;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class LectorDaoImpl extends AbstractDao implements LectorDao {

    public LectorDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Lector read(Integer integer) {
        entityManager.getTransaction().begin();
        Lector lector = entityManager.find(Lector.class, integer);
        entityManager.getTransaction().commit();
        return lector;
    }

    @Override
    public Integer create(Lector lector) {
        entityManager.getTransaction().begin();
        entityManager.persist(lector);
        Query query = entityManager.createNativeQuery("select max(lector.id) as maxId from lector");
        Integer id = (Integer) query.getSingleResult();
        entityManager.getTransaction().commit();
        return id;
    }

    @Override
    public void update(Lector lector) {
        entityManager.getTransaction().begin();
        entityManager.merge(lector);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Lector lector) {
        entityManager.getTransaction().begin();
        entityManager.remove(lector);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Lector> findAll() {
        entityManager.getTransaction().begin();
        List<Lector> lectors = entityManager.createNativeQuery("select * from lector",Lector.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return lectors;
    }
}
