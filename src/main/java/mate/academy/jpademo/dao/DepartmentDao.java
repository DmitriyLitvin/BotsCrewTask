package mate.academy.jpademo.dao;

import mate.academy.jpademo.model.Degree;
import mate.academy.jpademo.model.Department;

import java.util.List;

public interface DepartmentDao extends CrudDao<Department, Integer> {
    List<String> findHeadNameOfDepartment(String nameOfDepartment);

    Integer countOfLectors(String nameOfDepartment, Degree degree);

    Double getAvgSalaryOfDepartment(String nameOfDepartment);

    Integer countOfEmployees(String nameOfDepartment);
}
