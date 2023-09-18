package it.jdk.employeeservice.service;

import it.jdk.employeeservice.client.DepartmentClient;
import it.jdk.employeeservice.entity.DepartmentEntity;
import it.jdk.employeeservice.entity.EmployeeEntity;
import it.jdk.employeeservice.model.Department;
import it.jdk.employeeservice.model.Employee;
import it.jdk.employeeservice.repository.EmployeeRepository_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository_ employeeRepository;
//    private final DepartmentClient departmentClient;

    @Autowired
    public EmployeeService(EmployeeRepository_ employeeRepository, DepartmentClient departmentClient) {
        this.employeeRepository = employeeRepository;
//        this.departmentClient = departmentClient;
    }

    @Transactional(readOnly = false)
    public Employee insertEmployee(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();

        entity.setName(employee.getName());
        entity.setAge(employee.getAge());
        entity.setPosition(employee.getPosition());
        entity.setDepartmentId(employee.getDepartmentId());

        employeeRepository.save(entity);

        employee.setId(entity.getId());
        employee.setVersion(0);

        return employee;
    }

    public Employee getEmployeeById(Long id) {
        EmployeeEntity entity = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No employee with id " + id + " was found")
        );
        return new Employee(entity.getId(), entity.getName(), entity.getAge(), entity.getPosition(),
                entity.getDepartmentId(), entity.getVersion());
    }

    public List<Employee> getEmployeeByDepartmentId(Long departmentId) {
        List<EmployeeEntity> entities = employeeRepository.findByDepartmentId(departmentId);
        List<Employee> employees = new ArrayList<>();

        for(EmployeeEntity entity : entities) {
            employees.add(new Employee(entity.getId(), entity.getName(), entity.getAge(), entity.getPosition(),
                    entity.getDepartmentId(), entity.getVersion()));
        }
        return employees;
    }

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> entities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for(EmployeeEntity entity : entities) {
            employees.add(new Employee(entity.getId(), entity.getName(), entity.getAge(), entity.getPosition(),
                    entity.getDepartmentId(), entity.getVersion()));
        }
        return employees;
    }

}
