package com.example.firstSpring.controller;

import com.example.firstSpring.entity.Employee;
import com.example.firstSpring.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
//@RestController
public class EmployeeController {

  @Autowired
  EmployeeService employeesService;

  //@RequestMapping(value = "/employees", method = RequestMethod.GET)
  @GetMapping("/employees")
  public List<Employee> findAllEmployees() {
    List<Employee> employeesList = employeesService.getALlEmployees();
    return employeesList;
  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
  public Employee findAEmployee(@PathVariable int id) {
    return employeesService.findAEmployee(id);
  }

  //@RequestMapping(value = "/employees", method = RequestMethod.POST)
  @PostMapping("/employees")
  public void createEmployee(@RequestBody Employee employee) {
    employeesService.createEmployee(employee);
  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
  public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
    employeesService.updateEmployee(employee);
  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
  public void deleteEmployee(@PathVariable int id) {
    employeesService.deleteEmployee(1);
  }

}
