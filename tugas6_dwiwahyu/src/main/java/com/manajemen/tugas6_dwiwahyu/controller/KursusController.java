package com.manajemen.tugas6_dwiwahyu.controller;


import com.manajemen.tugas6_dwiwahyu.model.Kursus;
import com.manajemen.tugas6_dwiwahyu.service.InstrukturService;
import com.manajemen.tugas6_dwiwahyu.service.KursusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kursus")
public class KursusController {

    @Autowired
    private KursusService kursusService;

    @Autowired
    private InstrukturService instrukturService;

    @PostMapping
    public Kursus tambahKursus(@RequestParam String instrukturId, @RequestBody Map<String, Object> body) {
        var instruktur = instrukturService.getInstrukturById(instrukturId);
        if (instruktur == null) return null;

        String namaKursus = (String) body.get("namaKursus");
        int kuota = (int) body.get("kuota");
        return kursusService.tambahKursus(namaKursus, kuota, instruktur);
    }

    @GetMapping
    public List<Kursus> getAllKursus() {
        return kursusService.getAllKursus();
    }

    @GetMapping("/{kode}")
    public Kursus getKursus(@PathVariable String kode) {
        return kursusService.getKursusByKode(kode);
    }
}
