package com.example.produk.kuis5_dwiwahyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produk")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAllProduk() {
        return produkService.getAllProduk();
    }

    @PostMapping("")
    public String addProduk(@RequestBody Produk produk) {
        produkService.addProduk(produk);
        return "Produk berhasil ditambahkan.";
    }

    @GetMapping("/{kode}")
    public Produk getProdukByKode(@PathVariable String kode) {
        Produk produk = produkService.getProdukByKode(kode);
        if (produk != null) {
            return produk;
        }
        throw new RuntimeException("Produk dengan kode " + kode + " tidak ditemukan.");
    }

    @PutMapping("/{kode}")
    public String updateProduk(@PathVariable String kode, @RequestBody Produk produk) {
        boolean updated = produkService.updateProduk(kode, produk);
        if (updated) {
            return "Produk berhasil diupdate.";
        }
        return "Produk dengan kode " + kode + " tidak ditemukan.";
    }

    @DeleteMapping("/{kode}")
    public String deleteProduk(@PathVariable String kode) {
        boolean deleted = produkService.deleteProduk(kode);
        if (deleted) {
            return "Produk berhasil dihapus.";
        }
        return "Produk dengan kode " + kode + " tidak ditemukan.";
    }
}
