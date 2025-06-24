package com.manajemen.tugas6_dwiwahyu.controller;

import com.manajemen.tugas6_dwiwahyu.model.Instruktur;
import com.manajemen.tugas6_dwiwahyu.service.InstrukturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/instruktur")
public class InstrukturController {

    @Autowired
    private InstrukturService instrukturService;

    @PostMapping
    public Instruktur tambahInstruktur(@RequestBody Map<String, String> body) {
        return instrukturService.tambahInstruktur(body.get("nama"), body.get("keahlian"));
    }

    @GetMapping
    public List<Instruktur> getAllInstruktur() {
        return instrukturService.getAllInstruktur();
    }
}
