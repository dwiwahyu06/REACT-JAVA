package com.example.produk.kuis5_dwiwahyu;

public class Produk {
    private String nama;
    private String kode;
    private String kategori;
    private double harga;

    public Produk() {}

    public Produk(String nama, String kode, String kategori, double harga) {
        this.nama = nama;
        this.kode = kode;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
