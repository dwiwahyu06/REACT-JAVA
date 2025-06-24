package com.coffeshop.demo.controller;

import com.coffeshop.demo.model.Coffee;
import com.coffeshop.demo.repository.RepositoryCoffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coffee")
public class ControllerCoffee {

    @Autowired
    private RepositoryCoffee coffeeRepository;

    @GetMapping
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{code}")
    public Coffee getCoffeeByCode(@PathVariable Long code) {
        return coffeeRepository.findById(code).orElse(null);
    }

    @PostMapping
    public Map<String, Object> createCoffee(@RequestBody Coffee coffee) {
        Coffee savedCoffee = coffeeRepository.save(coffee);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Data coffee berhasil disimpan");
        response.put("data", savedCoffee);
        return response;
    }

    @PutMapping("/{code}")
    public Map<String, Object> updateCoffee(@PathVariable Long code, @RequestBody Coffee newCoffee) {
        Map<String, Object> response = new HashMap<>();
        Coffee coffee = coffeeRepository.findById(code).orElse(null);
        if (coffee != null) {
            coffee.setMerk(newCoffee.getMerk());
            coffee.setType(newCoffee.getType());
            coffee.setPrice(newCoffee.getPrice());
            coffeeRepository.save(coffee);

            response.put("message", "Data coffee dengan code " + code + " berhasil diupdate");
            response.put("data", coffee);
        } else {
            response.put("message", "Data coffee dengan code " + code + " tidak ditemukan");
            response.put("data", null);
        }
        return response;
    }

    @DeleteMapping("/{code}")
    public Map<String, Object> deleteCoffee(@PathVariable Long code) {
        Map<String, Object> response = new HashMap<>();
        Coffee coffee = coffeeRepository.findById(code).orElse(null);
        if (coffee != null) {
            coffeeRepository.deleteById(code);
            response.put("message", "Data coffee dengan code " + code + " berhasil dihapus");
        } else {
            response.put("message", "Data coffee dengan code " + code + " tidak ditemukan");
        }
        return response;
    }
}
