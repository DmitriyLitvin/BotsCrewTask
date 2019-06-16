package mate.academy.jpademo.service.impl;

import mate.academy.jpademo.dao.DepartmentDao;
import mate.academy.jpademo.model.Degree;
import mate.academy.jpademo.model.Department;
import mate.academy.jpademo.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department read(Integer id) {
        return departmentDao.read(id);
    }

    @Override
    public Integer create(Department lector) {
        return departmentDao.create(lector);
    }

    @Override
    public void update(Department lector) {
        departmentDao.update(lector);
    }

    @Override
    public void delete(Department lector) {
        departmentDao.delete(lector);
    }

    @Override
    public List<String> findHeadNameOfDepartment(String nameOfDepartment) {
        return departmentDao.findHeadNameOfDepartment(nameOfDepartment);
    }

    @Override
    public Integer countOfLectors(String nameOfDepartment, Degree degree) {
        return departmentDao.countOfLectors(nameOfDepartment,degree);
    }

    @Override
    public Double getAvgSalaryOfDepartment(String nameOfDepartment) {
        return departmentDao.getAvgSalaryOfDepartment(nameOfDepartment);
    }

    @Override
    public Long countOfEmployees(String nameOfDepartment) {
        return departmentDao.countOfEmployees(nameOfDepartment);
    }
}
