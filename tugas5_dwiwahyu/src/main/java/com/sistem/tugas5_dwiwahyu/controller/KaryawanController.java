package com.sistem.tugas5_dwiwahyu.controller;

import com.sistem.tugas5_dwiwahyu.model.Karyawan;
import com.sistem.tugas5_dwiwahyu.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {

    @Autowired
    private KaryawanService karyawanService;

    @GetMapping
    public List<Karyawan> getAllKaryawan() {
        return karyawanService.getAllKaryawan();
    }

    @PostMapping
    public String addKaryawan(@RequestBody Karyawan karyawan) {
        return karyawanService.addKaryawan(karyawan);
    }
}
