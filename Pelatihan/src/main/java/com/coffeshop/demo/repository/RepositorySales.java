package com.coffeshop.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeshop.demo.model.Sales;

public interface RepositorySales extends JpaRepository<Sales, Integer>{

    List<Sales> findByCoffeCode(Long coffeCode);

    Optional<Sales> findByBaristaId(Long baristaId);
}

