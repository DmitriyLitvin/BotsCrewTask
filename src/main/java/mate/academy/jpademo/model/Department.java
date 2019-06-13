package mate.academy.jpademo.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity(name = "department")
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "name_of_head")
    private String nameOfHead;

    @Column(name = "name_of_department")
    private String nameOfDepartment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="lector_department",
            joinColumns=@JoinColumn(name="department_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="lector_id", referencedColumnName="id"))
    private List<Lector>lectors;

    public Department() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    public String getNameOfhead() {
        return nameOfHead;
    }

    public void setNameOfhead(String nameOfHead) {
        this.nameOfHead = nameOfHead;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public String getNameOfHead() {
        return nameOfHead;
    }

    public void setNameOfHead(String nameOfHead) {
        this.nameOfHead = nameOfHead;
    }

    public void addLector(Lector lector) {
        if (lectors == null) {
            lectors = new LinkedList<>();
        }
        lectors.add(lector);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id.equals(that.id) &&
                nameOfHead.equals(that.nameOfHead) &&
                nameOfDepartment.equals(that.nameOfDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfHead, nameOfDepartment);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", nameOfHead='" + nameOfHead + '\'' +
                ", nameOfDepartment='" + nameOfDepartment + '\'' +
                '}';
    }
}
