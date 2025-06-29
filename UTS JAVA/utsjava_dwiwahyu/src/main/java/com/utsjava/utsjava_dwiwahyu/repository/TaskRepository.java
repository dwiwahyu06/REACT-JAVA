package com.utsjava.utsjava_dwiwahyu.repository;


import com.utsjava.utsjava_dwiwahyu.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
