package mate.academy.jpademo.dao.impl;

import mate.academy.jpademo.dao.AbstractDao;
import mate.academy.jpademo.dao.DepartmentDao;
import mate.academy.jpademo.model.Degree;
import mate.academy.jpademo.model.Department;
import mate.academy.jpademo.model.Lector;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentDaoImpl extends AbstractDao implements DepartmentDao {

    public DepartmentDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Department read(Integer integer) {
        entityManager.getTransaction().begin();
        Department department = entityManager.find(Department.class, integer);
        entityManager.getTransaction().commit();
        return department;
    }

    @Override
    public Integer create(Department department) {
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        Query query = entityManager.createNativeQuery("select max(department.id) as maxId " +
                "from department");
        Integer id = (Integer) query.getSingleResult();
        entityManager.getTransaction().commit();
        return id;
    }

    @Override
    public void update(Department department) {
        entityManager.getTransaction().begin();
        entityManager.merge(department);
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(Department department) {
        entityManager.getTransaction().begin();
        entityManager.remove(department);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<String> findHeadNameOfDepartment(String nameOfDepartment) {
        entityManager.getTransaction().begin();
        List<Department> departments = entityManager.createNativeQuery("select * " +
                "from department " +
                "where name_of_department = ?", Department.class)
                .setParameter(1, nameOfDepartment)
                .getResultList();
        entityManager.getTransaction().commit();

        List<String> names = departments
                .stream()
                .map(department -> department.getNameOfHead())
                .collect(Collectors.toList());

        return names;
    }

    @Override
    public Integer countOfLectors(String nameOfDepartment, Degree degree) {
        entityManager.getTransaction().begin();
        Integer count = ((BigInteger) entityManager.createNativeQuery("select count(*) " +
                "from lector inner join lector_department " +
                "on  lector.id = lector_department.lector_id " +
                "inner join department " +
                "on department.id = lector_department.department_id " +
                "where name_of_department = ? and degree = ?")
                .setParameter(1, nameOfDepartment)
                .setParameter(2, degree.toString())
                .getSingleResult()).intValue();
        entityManager.getTransaction().commit();

        return count;

    }

    @Override
    public Double getAvgSalaryOfDepartment(String nameOfDepartment) {
        entityManager.getTransaction().begin();
        Double avgSalary = (Double) entityManager.createNativeQuery("select avg(lector.salary) " +
                "from lector inner join lector_department " +
                "on  lector.id = lector_department.lector_id " +
                "inner join department " +
                "on department.id = lector_department.department_id " +
                "where name_of_department = ?")
                .setParameter(1, nameOfDepartment)
                .getSingleResult();
        entityManager.getTransaction().commit();

        return avgSalary;
    }

    @Override
    public Long countOfEmployees(String nameOfDepartment) {
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Department> departmentRoot = cq.from(Department.class);
        cq.where(cb.equal(departmentRoot.get("nameOfDepartment"), nameOfDepartment));
        Join<Lector, Department> departmentLectorJoin =
                departmentRoot.join("lectors", JoinType.INNER);
        cq.select(cb.count(departmentLectorJoin));
        TypedQuery<Long> query = entityManager.createQuery(cq);

        entityManager.getTransaction().commit();

        return query.getSingleResult();
    }
}
