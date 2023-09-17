package it.jdk.employeeservice.model;

/**
 * Record keyword is used to build an immutable class with constructor, setters and getters automatically provided
 * @param id employee's id
 * @param departmentId employee department's id
 * @param name employee's name
 * @param age employee's age
 * @param position employee's position in their department
 */
public record Employee(Long id, Long departmentId, String name, int age, String position) {}
