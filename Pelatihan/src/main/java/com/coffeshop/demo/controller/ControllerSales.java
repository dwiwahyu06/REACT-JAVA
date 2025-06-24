package com.coffeshop.demo.controller;

import com.coffeshop.demo.model.Barista;
import com.coffeshop.demo.model.Coffee;
import com.coffeshop.demo.model.Sales;
import com.coffeshop.demo.repository.RepositoryBarista;
import com.coffeshop.demo.repository.RepositoryCoffee;
import com.coffeshop.demo.repository.RepositorySales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class ControllerSales {

    @Autowired
    private RepositorySales salesRepository;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Sales getSalesById(@PathVariable Integer id) {
        return salesRepository.findById(id).orElse(null);
    }

    // @PostMapping
    // public Sales createSales(@RequestBody Sales sales) {
    //     return salesRepository.save(sales);
    // }

    @PostMapping("/add-sales")
public Map<String, Object> addSales(@RequestBody Map<String, Object> payload) {
    Map<String, Object> response = new LinkedHashMap<>();

    try {
        String date = (String) payload.get("date");
        Long coffeeCode = Long.valueOf(payload.get("coffeeCode").toString());
        Long baristaId = Long.valueOf(payload.get("baristaId").toString());

        Optional<Coffee> coffee = RepositoryCoffee.findById();
        Optional<Barista> barista = RepositoryBarista.findById();

        if (coffee.isPresent() && barista.isPresent()) {
            Sales sales = new Sales();
            sales.setDate(date);
            sales.setCoffee(coffee.get());
            sales.setBarista(barista.get());

            Sales savedSales = salesRepository.save(sales);

            response.put("message", "Berhasil menyimpan data penjualan");
            response.put("data", savedSales);
        } else {
            response.put("message", "Coffee atau Barista tidak ditemukan");
        }

    } catch (Exception e) {
        response.put("message", "Gagal menyimpan data: " + e.getMessage());
    }

    return response;
}


    @PutMapping("/{id}")
    public Sales updateSales(@PathVariable Integer id, @RequestBody Sales newSales) {
        Sales sales = salesRepository.findById(id).orElse(null);
        if (sales != null) {
            sales.setDate(newSales.getDate());
            sales.setCodeCoffee(newSales.getCodeCoffee());
            sales.setIdBarista(newSales.getIdBarista());
            return salesRepository.save(sales);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSales(@PathVariable Integer id) {
        salesRepository.deleteById(id);
    }
}
