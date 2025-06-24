package com.manajemen.tugas6_dwiwahyu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Peserta {
    private String id;
    private String nama;
    private String email;
    private List<Kursus> kursusDiikuti;

    public Peserta(String nama, String email) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.email = email;
        this.kursusDiikuti = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public List<Kursus> getKursusDiikuti() { return kursusDiikuti; }

    public void tambahKursus(Kursus kursus) {
        this.kursusDiikuti.add(kursus);
    }
}