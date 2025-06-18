package com.sistem.tugas5_dwiwahyu.service;

import com.sistem.tugas5_dwiwahyu.model.Karyawan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KaryawanService {

    private List<Karyawan> listKaryawan = new ArrayList<>();
    private final ProyekService proyekService;

    public KaryawanService(ProyekService proyekService) {
        this.proyekService = proyekService;
    }

    public List<Karyawan> getAllKaryawan() {
        return listKaryawan;
    }

    public String addKaryawan(Karyawan karyawan) {
        // Validasi: semua kodeProyek harus ada di list proyek
        for (String kode : karyawan.getKodeProyek()) {
            if (!proyekService.kodeProyekExists(kode)) {
                return "Gagal: Kode Proyek " + kode + " tidak ditemukan.";
            }
        }
        listKaryawan.add(karyawan);
        return "Berhasil tambah karyawan dengan ID: " + karyawan.getId();
    }
}
