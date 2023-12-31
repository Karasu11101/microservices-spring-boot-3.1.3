package it.jdk.departmentservice.model;

public class Employee {

    private Long id;
    private String name;
    private int age;
    private String position;
    private Department department;
    private int version;

    public Employee() {}

    public Employee(Long id, String name, int age, String position, Department department, int version) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.department = department;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
