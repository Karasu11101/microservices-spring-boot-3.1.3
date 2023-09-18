package it.jdk.employeeservice.repository;

import it.jdk.employeeservice.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository_ extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findById(Long id);
    @Query("SELECT e from Employee e WHERE e.departmentId = :departmentId")
    List<EmployeeEntity> findByDepartmentId(@Param("departmentId") Long departmentId);
    List<EmployeeEntity> findAll();
}
