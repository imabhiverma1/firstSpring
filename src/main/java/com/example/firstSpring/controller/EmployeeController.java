package com.example.firstSpring.controller;

import com.example.firstSpring.entity.Employee;
import com.example.firstSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Employee> deleteEmployee(@PathVariable int id) {

        return employeesService.deleteEmployee(1);

    }
}
