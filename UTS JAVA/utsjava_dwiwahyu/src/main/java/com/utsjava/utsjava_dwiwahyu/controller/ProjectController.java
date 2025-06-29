package com.utsjava.utsjava_dwiwahyu.controller;


import com.utsjava.utsjava_dwiwahyu.model.Project;
import com.utsjava.utsjava_dwiwahyu.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepo;

    @GetMapping("/all")
    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Project getById(@PathVariable Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public Project create(@RequestBody Project project) {
        return projectRepo.save(project);
    }

    @PutMapping("/update/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        return projectRepo.save(project);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        projectRepo.deleteById(id);
    }

    @GetMapping("/search/{keyword}")
    public List<Project> search(@PathVariable String keyword) {
        return projectRepo.findByTitleContainingIgnoreCase(keyword);
    }

    @GetMapping("/sort-asc")
    public List<Project> sortAsc() {
        return projectRepo.findAllByOrderByTitleAsc();
    }

    @GetMapping("/sort-desc")
    public List<Project> sortDesc() {
        return projectRepo.findAllByOrderByTitleDesc();
    }
}
