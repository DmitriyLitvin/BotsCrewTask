package mate.academy.jpademo.service;

import mate.academy.jpademo.model.Degree;
import mate.academy.jpademo.model.Department;

import java.util.List;

public interface DepartmentService {
    Department read(Integer id);

    Integer create(Department lector);

    void update(Department lector);

    void delete(Department lector);

    List<String> findHeadNameOfDepartment(String nameOfDepartment);

    Integer countOfLectors(String nameOfDepartment, Degree degree);

    Double getAvgSalaryOfDepartment(String nameOfDepartment);

    Long countOfEmployees(String nameOfDepartment);
}
