package mate.academy.jpademo.service.factory;

import mate.academy.jpademo.dao.impl.DepartmentDaoImpl;
import mate.academy.jpademo.dao.impl.LectorDaoImpl;
import mate.academy.jpademo.service.DepartmentService;
import mate.academy.jpademo.service.LectorService;
import mate.academy.jpademo.service.impl.DepartmentServiceImpl;
import mate.academy.jpademo.service.impl.LectorServiceImpl;
import mate.academy.jpademo.util.HibernateUtil;

import javax.persistence.EntityManager;

public class ServiceFactory {
    private static final EntityManager entityManager;

    static {
        entityManager = HibernateUtil.getEntityManager();
    }

    public static DepartmentService getDepartmentService() {
        return new DepartmentServiceImpl(new DepartmentDaoImpl(entityManager));
    }

    public static LectorService getLectorService() {
        return new LectorServiceImpl(new LectorDaoImpl(entityManager));
    }
}
