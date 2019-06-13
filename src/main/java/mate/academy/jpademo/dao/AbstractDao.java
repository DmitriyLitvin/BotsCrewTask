package mate.academy.jpademo.dao;

import javax.persistence.EntityManager;

public abstract class AbstractDao {
    protected EntityManager entityManager;

    protected AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
