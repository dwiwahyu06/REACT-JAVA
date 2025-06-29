package com.utsjava.utsjava_dwiwahyu.repository;


import com.utsjava.utsjava_dwiwahyu.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFullNameContainingIgnoreCase(String keyword);
    List<Employee> findAllByOrderByFullNameAsc();
    List<Employee> findAllByOrderByFullNameDesc();
}
