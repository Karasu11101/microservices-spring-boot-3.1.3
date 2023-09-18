package it.jdk.employeeservice.client;

import it.jdk.employeeservice.model.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface DepartmentClient {

    /**
     * Method that calls the findById method in DepartmentController
     * @param departmentId id of the department
     * @return the department with the specified id
     */
    @GetExchange("department/{departmentId}")
    public Department findDepartment(@PathVariable("departmentId") Long departmentId);
}
