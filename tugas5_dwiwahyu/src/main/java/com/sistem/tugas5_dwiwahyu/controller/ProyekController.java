package com.sistem.tugas5_dwiwahyu.controller;

import com.sistem.tugas5_dwiwahyu.model.Proyek;
import com.sistem.tugas5_dwiwahyu.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekService.getAllProyek();
    }

    @PostMapping
    public String addProyek(@RequestBody Proyek proyek) {
        return proyekService.addProyek(proyek);
    }
}
