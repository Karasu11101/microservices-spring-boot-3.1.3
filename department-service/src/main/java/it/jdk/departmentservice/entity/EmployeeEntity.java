package it.jdk.departmentservice.entity;

import jakarta.persistence.*;

@Entity(name = "Employee")
@Table(name = "employee")
@SequenceGenerator(name = "employee_generator", sequenceName = "employee_generator", initialValue = 1, allocationSize = 1)
public class EmployeeEntity {

    private Long id;
    private String name;
    private int age;
    private String position;
    private Long departmentId;
    private int version;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "employee_generator", strategy = GenerationType.SEQUENCE)
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

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "department_id")
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
