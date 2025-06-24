package com.coffeshop.demo.controller;

import com.coffeshop.demo.model.Barista;
import com.coffeshop.demo.repository.RepositoryBarista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barista")
public class ControllerBarista {

    @Autowired
    private RepositoryBarista baristaRepository;

    @GetMapping
    public List<Barista> getAllBarista() {
        return baristaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Barista getBaristaById(@PathVariable Long id) {
        return baristaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Barista createBarista(@RequestBody Barista barista) {
        return baristaRepository.save(barista);
    }

    @PutMapping("/{id}")
    public Barista updateBarista(@PathVariable Long id, @RequestBody Barista newBarista) {
        Barista barista = baristaRepository.findById(id).orElse(null);
        if (barista != null) {
            barista.setName(newBarista.getName());
            barista.setAge(newBarista.getAge());
            barista.setGender(newBarista.getGender());
            barista.setEmail(newBarista.getEmail());
            return baristaRepository.save(barista);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBarista(@PathVariable Long id) {
        baristaRepository.deleteById(id);
    }
}
