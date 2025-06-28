package com.project.kuis11_dwiwahyu.repository;

import com.project.kuis11_dwiwahyu.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}