package com.utsjava.utsjava_dwiwahyu.controller;


import com.utsjava.utsjava_dwiwahyu.model.Department;
import com.utsjava.utsjava_dwiwahyu.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    private DepartmentRepository departmentRepo;

    @GetMapping("/all")
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Department getById(@PathVariable Long id) {
        return departmentRepo.findById(id).orElse(null);
    }

  @PostMapping("/create")
public Department create(@RequestBody Department department) {
    return departmentRepo.save(department);
}

    @PutMapping("/update/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        return departmentRepo.save(department);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        departmentRepo.deleteById(id);
    }
}
