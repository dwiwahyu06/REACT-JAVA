package com.utsjava.utsjava_dwiwahyu.controller;


import com.utsjava.utsjava_dwiwahyu.model.Company;
import com.utsjava.utsjava_dwiwahyu.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepo;

    @GetMapping("/all")
    public List<Company> getAll() {
        return companyRepo.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Company getById(@PathVariable Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public Company create(@RequestBody Company company) {
        return companyRepo.save(company);
    }

    @PutMapping("/update/{id}")
    public Company update(@PathVariable Long id, @RequestBody Company company) {
        company.setId(id);
        return companyRepo.save(company);
    }

   @DeleteMapping("/delete/{id}")
public ResponseEntity<String> delete(@PathVariable Long id) {
    if (companyRepo.existsById(id)) {
        companyRepo.deleteById(id);
        return ResponseEntity.ok("Company dengan ID " + id + " berhasil dihapus.");
    } else {
        return ResponseEntity.status(404).body("Company dengan ID " + id + " tidak ditemukan.");
    }
}

}
