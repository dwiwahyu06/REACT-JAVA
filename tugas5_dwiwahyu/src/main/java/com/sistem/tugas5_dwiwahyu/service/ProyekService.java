package com.sistem.tugas5_dwiwahyu.service;

import com.sistem.tugas5_dwiwahyu.model.Proyek;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyekService {

    private List<Proyek> listProyek = new ArrayList<>();

    public List<Proyek> getAllProyek() {
        return listProyek;
    }

    public String addProyek(Proyek proyek) {
        listProyek.add(proyek);
        return "Berhasil tambah proyek dengan kode: " + proyek.getKode();
    }

    public boolean kodeProyekExists(String kode) {
        return listProyek.stream().anyMatch(p -> p.getKode().equals(kode));
    }
}
