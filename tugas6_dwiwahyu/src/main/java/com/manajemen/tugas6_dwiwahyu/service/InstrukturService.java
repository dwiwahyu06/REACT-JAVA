package com.manajemen.tugas6_dwiwahyu.service;

import com.manajemen.tugas6_dwiwahyu.model.Instruktur;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstrukturService {
    private List<Instruktur> instrukturList = new ArrayList<>();

    public Instruktur tambahInstruktur(String nama, String keahlian) {
        Instruktur instruktur = new Instruktur(nama, keahlian);
        instrukturList.add(instruktur);
        return instruktur;
    }

    public List<Instruktur> getAllInstruktur() {
        return instrukturList;
    }

    public Instruktur getInstrukturById(String id) {
        return instrukturList.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }
}
