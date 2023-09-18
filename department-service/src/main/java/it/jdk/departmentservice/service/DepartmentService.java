package it.jdk.departmentservice.service;

import it.jdk.departmentservice.client.EmployeeClient;
import it.jdk.departmentservice.entity.DepartmentEntity;
import it.jdk.departmentservice.model.Department;
import it.jdk.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }

    @Transactional(readOnly = false)
    public Department insertDepartment(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setName(department.getName());
//        departmentEntity.setEmployees(new ArrayList<>());

        departmentRepository.save(departmentEntity);

        department.setId(departmentEntity.getId());
        department.setEmployees(new ArrayList<>());
        department.setVersion(0);

        return department;
    }

    public Department getDepartment(Long id) {
        Optional<DepartmentEntity> entity = departmentRepository.findById(id);
        DepartmentEntity object = entity.orElseThrow(
                () -> new RuntimeException("No department with id " + id + " was found")
        );
        return new Department(object.getId(), object.getName(), object.getVersion());
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();

        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        for(DepartmentEntity entity : departmentEntities) {
            departments.add(new Department(entity.getId(), entity.getName(), entity.getVersion()));
        }
        return departments;
    }

    public List<Department> getAllDepartmentsWithEmployees() {
        List<Department> departments = getAllDepartments();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartmentId(department.getId())));
        return departments;
    }

}
