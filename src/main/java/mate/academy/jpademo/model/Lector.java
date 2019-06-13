package mate.academy.jpademo.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity(name = "lector")
@Table
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="lector_department",
            joinColumns=@JoinColumn(name="lector_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="department_id", referencedColumnName="id"))
    private List<Department> departments;

    public Lector() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void addDepartment(Department department) {
        if (departments == null) {
            departments = new LinkedList<>();
        }
        departments.add(department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return id.equals(lector.id) &&
                Objects.equals(name, lector.name) &&
                Objects.equals(surname, lector.surname) &&
                Objects.equals(salary, lector.salary) &&
                degree == lector.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, salary, degree);
    }

    @Override
    public String toString() {
        return "Lector{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
