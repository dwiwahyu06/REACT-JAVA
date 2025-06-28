package com.project.kuis11_dwiwahyu.controller;


import com.project.kuis11_dwiwahyu.model.Employee;
import com.project.kuis11_dwiwahyu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/search/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    
    @GetMapping("/sort/asc")
    public List<Employee> sortByNameAsc() {
        return employeeRepository.findAllByOrderByNameAsc();
    
    }

     @GetMapping("/sort/desc")
    public List<Employee> sortByNamedesc() {
        return employeeRepository.findAllByOrderByNameDesc();
    
    }
    

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            return employeeRepository.save(employee);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
