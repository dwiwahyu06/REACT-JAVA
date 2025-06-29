package com.utsjava.utsjava_dwiwahyu.controller;


import com.utsjava.utsjava_dwiwahyu.model.Task;
import com.utsjava.utsjava_dwiwahyu.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepo;

    // GET all tasks
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    // GET task by id
    @GetMapping("/by-id/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    // POST create new task
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    // PUT update task by id
    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskRepo.save(task);
    }

    // DELETE task by id
   @DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteTask(@PathVariable Long id) {
    if (taskRepo.existsById(id)) {
        taskRepo.deleteById(id);
        return ResponseEntity.ok("Task dengan ID " + id + " berhasil dihapus.");
    } else {
        return ResponseEntity.status(404).body("Task dengan ID " + id + " tidak ditemukan.");
    }
}

}
