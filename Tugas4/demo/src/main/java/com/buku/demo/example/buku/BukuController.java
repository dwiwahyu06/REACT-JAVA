package com.example.buku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @GetMapping
    public List<Buku> getSemuaBuku() {
        return bukuService.getSemuaBuku();
    }

    @PostMapping
    public String tambahBuku(@RequestBody Buku buku) {
        bukuService.tambahBuku(buku);
        return "Buku berhasil ditambahkan.";
    }

    @GetMapping("/{id}")
    public Buku getBukuById(@PathVariable String id) {
        return bukuService.getBukuById(id)
                .orElseThrow(() -> new RuntimeException("Buku tidak ditemukan dengan ID: " + id));
    }
}
