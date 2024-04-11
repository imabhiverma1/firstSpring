package com.example.firstSpring.service;

import com.example.firstSpring.entity.Employee;
import com.example.firstSpring.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  List<Employee> employeesList = new ArrayList<>(Arrays.asList(
      new Employee(1, "First Employee", "Delhi"),
      new Employee(2, "Second Employee", "Noida")
  ));

  EmployeeRepository employeeRepository;

  @Autowired
  EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public List<Employee> getALlEmployees() {
    return employeeRepository.findAll();
  }

  public Employee findAEmployee(int employeeId) {
   /* return employeesList
        .stream()
        .filter(employee -> employee.getEmployeeId() == employeeId)
        .findFirst()
        .get();*/
    return employeeRepository.findById(employeeId)
        .orElseThrow(() -> new RuntimeException("Not Found"));
  }

  public void createEmployee(Employee employee) {
    //employeesList.add(employee);
    employeeRepository.save(employee);
  }

  public void updateEmployee(Employee employee) {
        /*List<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeesList) {
            if (emp.getEmployeeId() == employee.getEmployeeId()) {
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployee.add(emp);
        }
        this.employeesList = tempEmployee;*/
    employeeRepository.save(employee);
  }

  public void deleteEmployee(int id) {
        /*List<Employee> tempEmployee = new ArrayList<>();

        for (Employee employee : employeesList) {
            if (employee.getEmployeeId() == id)
                continue;

            tempEmployee.add(employee);
        }
        this.employeesList = tempEmployee;
        return employeesList;*/
    employeeRepository.delete(employeeRepository.getById(id));
  }
}
