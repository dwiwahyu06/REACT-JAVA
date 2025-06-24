package com.manajemen.tugas6_dwiwahyu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Kursus {
    private String kode;
    private String namaKursus;
    private int kuota;
    private Instruktur instruktur;
    private List<Peserta> pesertaList;

    public Kursus(String namaKursus, int kuota, Instruktur instruktur) {
        this.kode = UUID.randomUUID().toString();
        this.namaKursus = namaKursus;
        this.kuota = kuota;
        this.instruktur = instruktur;
        this.pesertaList = new ArrayList<>();
    }

    public String getKode() { return kode; }
    public String getNamaKursus() { return namaKursus; }
    public int getKuota() { return kuota; }
    public Instruktur getInstruktur() { return instruktur; }
    public List<Peserta> getPesertaList() { return pesertaList; }

    public boolean tambahPeserta(Peserta peserta) {
        if (pesertaList.size() < kuota) {
            pesertaList.add(peserta);
            return true;
        }
        return false;
    }
}
