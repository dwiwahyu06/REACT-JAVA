package com.utsjava.utsjava_dwiwahyu.controller;


import com.utsjava.utsjava_dwiwahyu.model.Employee;
import com.utsjava.utsjava_dwiwahyu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeRepo.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepo.deleteById(id);
    }

    @GetMapping("/search/{keyword}")
    public List<Employee> search(@PathVariable String keyword) {
        return employeeRepo.findByFullNameContainingIgnoreCase(keyword);
    }

    @GetMapping("/sort-asc")
    public List<Employee> sortAsc() {
        return employeeRepo.findAllByOrderByFullNameAsc();
    }

    @GetMapping("/sort-desc")
    public List<Employee> sortDesc() {
        return employeeRepo.findAllByOrderByFullNameDesc();
    }
}

