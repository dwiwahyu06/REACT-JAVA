package com.project.kuis11_dwiwahyu.repository;

import com.project.kuis11_dwiwahyu.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
    //terkecil ke terbesar
     List<Employee> findAllByOrderByNameAsc();

    //terbesar ke terkecil
    List<Employee> findAllByOrderByNameDesc();
}