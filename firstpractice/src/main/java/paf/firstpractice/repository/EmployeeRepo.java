package paf.firstpractice.repository;

import java.util.List;

import paf.firstpractice.model.Employee;

public interface EmployeeRepo {

    List<Employee> retrieveEmployeeList();

    // Create
    Boolean save(Employee employee);

    // Update
    int update(Employee employee);

    // Delete
    int deleteById(Integer id);

}
