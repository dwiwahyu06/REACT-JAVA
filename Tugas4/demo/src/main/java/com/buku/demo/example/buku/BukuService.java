package com.example.buku;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BukuService {
    private List<Buku> daftarBuku = new ArrayList<>();

    public List<Buku> getSemuaBuku() {
        return daftarBuku;
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public Optional<Buku> getBukuById(String id) {
        return daftarBuku.stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}
