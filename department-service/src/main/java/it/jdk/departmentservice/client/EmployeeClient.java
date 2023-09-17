package it.jdk.departmentservice.client;

import it.jdk.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    /**
     * Method that calls the findByDepartment method in EmployeeController
     * @param departmentId id of the department
     * @return a list of employees belonging to the specified department
     */
    @GetExchange("employee/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
