package com.manajemen.tugas6_dwiwahyu.service;

import com.manajemen.tugas6_dwiwahyu.model.Instruktur;
import com.manajemen.tugas6_dwiwahyu.model.Kursus;
import com.manajemen.tugas6_dwiwahyu.model.Peserta;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class KursusService {
    private List<Kursus> kursusList = new ArrayList<>();

    public Kursus tambahKursus(String namaKursus, int kuota, Instruktur instruktur) {
        Kursus kursus = new Kursus(namaKursus, kuota, instruktur);
        kursusList.add(kursus);
        return kursus;
    }

    public List<Kursus> getAllKursus() {
        return kursusList;
    }

    public Kursus getKursusByKode(String kode) {
        return kursusList.stream().filter(k -> k.getKode().equals(kode)).findFirst().orElse(null);
    }

    public boolean daftarPeserta(Peserta peserta, String kodeKursus) {
        Kursus kursus = getKursusByKode(kodeKursus);
        if (kursus != null && kursus.tambahPeserta(peserta)) {
            peserta.tambahKursus(kursus);
            return true;
        }
        return false;
    }
}
