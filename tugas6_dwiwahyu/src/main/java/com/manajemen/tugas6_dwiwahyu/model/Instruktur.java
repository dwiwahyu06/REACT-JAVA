package com.manajemen.tugas6_dwiwahyu.model;

import java.util.UUID;

public class Instruktur {
    private String id;
    private String nama;
    private String keahlian;

    public Instruktur(String nama, String keahlian) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.keahlian = keahlian;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getKeahlian() { return keahlian; }
}
