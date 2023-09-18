package it.jdk.employeeservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Department")
@Table(name = "department")
@SequenceGenerator(name = "department_generator", sequenceName = "department_generator", initialValue = 1, allocationSize = 1)
public class DepartmentEntity {

    private Long id;
    private String name;
    private List<EmployeeEntity> employees;
    private int version;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "department_generator", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public List<EmployeeEntity> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<EmployeeEntity> employees) {
//        this.employees = employees;
//    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
