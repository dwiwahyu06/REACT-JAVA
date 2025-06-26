package com.example.produk.kuis5_dwiwahyu;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdukService {
    private List<Produk> daftarProduk = new ArrayList<>();

    public List<Produk> getAllProduk() {
        return daftarProduk;
    }

    public void addProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public Produk getProdukByKode(String kode) {
        return daftarProduk.stream()
                .filter(p -> p.getKode().equalsIgnoreCase(kode))
                .findFirst()
                .orElse(null);
    }

    public boolean updateProduk(String kode, Produk produkBaru) {
        Produk produk = getProdukByKode(kode);
        if (produk != null) {
            produk.setNama(produkBaru.getNama());
            produk.setKategori(produkBaru.getKategori());
            produk.setHarga(produkBaru.getHarga());
            return true;
        }
        return false;
    }

    public boolean deleteProduk(String kode) {
        Produk produk = getProdukByKode(kode);
        if (produk != null) {
            daftarProduk.remove(produk);
            return true;
        }
        return false;
    }
}
