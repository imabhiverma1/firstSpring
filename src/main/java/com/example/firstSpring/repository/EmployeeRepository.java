package com.example.firstSpring.repository;

import com.example.firstSpring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /*
     * C- Create (POST)
     * R- Read (GET)
     * U- Update (PUT)
     * D- Delete (DELETE)
     *
     * getAllEmployees()
     * getEmployee()
     * updateEmployee(Employee employee)
     * deleteEmployee(Employee employee)
     * */

    /*
     *   JPA is Java Persistence API
     * ORM Object RRelational Mapping
     */
}
