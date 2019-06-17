import mate.academy.jpademo.model.Degree;
import mate.academy.jpademo.service.DepartmentService;
import mate.academy.jpademo.service.LectorService;
import mate.academy.jpademo.service.factory.ServiceFactory;

import java.util.Scanner;

public class Interface {
    private DepartmentService departmentService;
    private LectorService lectorService;
    private Scanner scanner;

    public Interface(DepartmentService departmentService,
                     LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        this.scanner = new Scanner(System.in);
    }

    /*Enter 1,2,3,4,5 to get information about lectors and departments*/
    public void showStatistic() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            int number = scanner.nextInt();
            String department;
            String pattern;
            switch (number) {
                case 1:
                    System.out.print("Enter department : ");
                    department = scanner.next();
                    System.out.println("Head of " + department + " department is : "
                            + departmentService.findHeadNameOfDepartment(department));
                    break;
                case 2:
                    System.out.print("Enter department : ");
                    department = scanner.next();
                    System.out.println("Assistants : " +
                            departmentService.countOfLectors(department, Degree.ASSISTANT));
                    System.out.println("Associate professors : " +
                            departmentService.countOfLectors(department, Degree.ASSOCIATE_PROFESSOR));
                    System.out.println("Professors : " +
                            departmentService.countOfLectors(department, Degree.PROFESSOR));
                    break;
                case 3:
                    System.out.print("Enter department : ");
                    department = scanner.next();
                    System.out.println("The average salary of " + department + " is : "
                            + departmentService.getAvgSalaryOfDepartment(department));
                    break;
                case 4:
                    System.out.print("Enter department : ");
                    department = scanner.next();
                    System.out.println("Count for employee for " + department + " is : "
                            + departmentService.countOfEmployees(department));
                    break;
                case 5:
                    System.out.print("Enter pattern : ");
                    pattern = scanner.next();
                    lectorService.showLectorsWithTemplateSearch(pattern);
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Interface(ServiceFactory.getDepartmentService(),
                ServiceFactory.getLectorService()).showStatistic();
    }
}
