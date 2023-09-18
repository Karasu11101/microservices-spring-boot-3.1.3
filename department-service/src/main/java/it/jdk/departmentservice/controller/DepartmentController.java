package it.jdk.departmentservice.controller;

import it.jdk.departmentservice.client.EmployeeClient;
import it.jdk.departmentservice.model.Department;
import it.jdk.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/new")
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department inserted: {}", department);
        return departmentService.insertDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> findAll() {
        LOGGER.info("Department found");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        LOGGER.info("Department find: id={}", id);
        return departmentService.getDepartment(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        return departmentService.getAllDepartmentsWithEmployees();
    }
}
