package com.manajemen.tugas6_dwiwahyu.controller;


import com.manajemen.tugas6_dwiwahyu.model.Peserta;
import com.manajemen.tugas6_dwiwahyu.service.KursusService;
import com.manajemen.tugas6_dwiwahyu.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/peserta")
public class PesertaController {

    @Autowired
    private PesertaService pesertaService;

    @Autowired
    private KursusService kursusService;

    @PostMapping
    public Peserta tambahPeserta(@RequestBody Map<String, String> body) {
        return pesertaService.tambahPeserta(body.get("nama"), body.get("email"));
    }

    @GetMapping
    public List<Peserta> getAllPeserta() {
        return pesertaService.getAllPeserta();
    }

    @PostMapping("/{id}/daftar/{kodeKursus}")
    public String daftarKursus(@PathVariable String id, @PathVariable String kodeKursus) {
        var peserta = pesertaService.getPesertaById(id);
        if (peserta == null) return "Peserta tidak ditemukan";

        boolean result = kursusService.daftarPeserta(peserta, kodeKursus);
        return result ? "Berhasil daftar kursus" : "Kursus penuh atau tidk ditemukan";
    }
}
