package mate.academy.jpademo;

import mate.academy.jpademo.model.Degree;
import mate.academy.jpademo.model.Department;
import mate.academy.jpademo.model.Lector;
import mate.academy.jpademo.service.DepartmentService;
import mate.academy.jpademo.service.LectorService;
import mate.academy.jpademo.service.factory.ServiceFactory;

public class Main {
    public static void main(String[] args) {
        LectorService lectorService = ServiceFactory.getLectorService();

        Lector lector = new Lector();
        lector.setName("Dima");
        lector.setSurname("Badoev");
        lector.setDegree(Degree.ASSISTANT);
        lector.setSalary(2000.25);
        lectorService.create(lector);

        Lector lector1 = new Lector();
        lector1.setName("Kate");
        lector1.setSurname("Chornoculska");
        lector1.setDegree(Degree.ASSOCIATE_PROFESSOR);
        lector1.setSalary(6000.25);
        lectorService.create(lector1);

        Lector lector2 = new Lector();
        lector2.setName("Ann");
        lector2.setSurname("Zikova");
        lector2.setDegree(Degree.PROFESSOR);
        lector2.setSalary(12000.45);
        lectorService.create(lector2);

        Lector lector3 = new Lector();
        lector3.setName("Anastasia");
        lector3.setSurname("Litvin");
        lector3.setDegree(Degree.PROFESSOR);
        lector3.setSalary(13000.45);
        lectorService.create(lector3);

        DepartmentService departmentService = ServiceFactory.getDepartmentService();
        Department department = new Department();
        department.setNameOfDepartment("diff_equantion");
        department.setNameOfhead("Dima");
        department.addLector(lector);
        department.addLector(lector1);
        department.addLector(lector2);
        departmentService.create(department);

        department = new Department();
        department.setNameOfDepartment("algebra");
        department.setNameOfhead("Ludmila");
        department.addLector(lector);
        department.addLector(lector2);
        departmentService.create(department);

        department = new Department();
        department.setNameOfDepartment("calculus");
        department.setNameOfhead("Oleksandr");
        department.addLector(lector);
        department.addLector(lector1);
        department.addLector(lector2);
        department.addLector(lector3);
        departmentService.create(department);
    }
}
