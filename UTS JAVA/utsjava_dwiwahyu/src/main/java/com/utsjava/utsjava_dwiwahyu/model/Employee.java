package com.utsjava.utsjava_dwiwahyu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
