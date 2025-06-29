package com.utsjava.utsjava_dwiwahyu.repository;

import com.utsjava.utsjava_dwiwahyu.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByTitleContainingIgnoreCase(String keyword);
    List<Project> findAllByOrderByTitleAsc();
    List<Project> findAllByOrderByTitleDesc();
}
