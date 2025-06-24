package com.manajemen.tugas6_dwiwahyu.service;


import com.manajemen.tugas6_dwiwahyu.model.Peserta;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PesertaService {
    private List<Peserta> pesertaList = new ArrayList<>();

    public Peserta tambahPeserta(String nama, String email) {
        Peserta peserta = new Peserta(nama, email);
        pesertaList.add(peserta);
        return peserta;
    }

    public List<Peserta> getAllPeserta() {
        return pesertaList;
    }

    public Peserta getPesertaById(String id) {
        return pesertaList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}

