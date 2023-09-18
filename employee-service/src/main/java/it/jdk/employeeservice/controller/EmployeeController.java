package it.jdk.employeeservice.controller;

import it.jdk.employeeservice.model.Employee;
import it.jdk.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/new")
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return employeeService.insertEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> findAll() {
        LOGGER.info("Employee find all");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return employeeService.getEmployeeByDepartmentId(departmentId);
    }
}
