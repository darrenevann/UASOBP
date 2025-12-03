// Leticia Michelle Purba (8252401440)

package com.example.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demospringboot.entity.Kurir;
import com.example.demospringboot.service.KurirService;

@Controller
@RequestMapping("/kurir") 
public class KurirController {

    @Autowired
    private KurirService kurirService;

    // Tampilkan Daftar & Form
    @GetMapping("/manage")
    public String manageKurir(Model model) {
        model.addAttribute("kurirList", kurirService.getAllKurir());
        model.addAttribute("newKurir", new Kurir()); 
        return "admin_kurir_manage"; 
    }

    // Simpan Data
    @PostMapping("/save")
    public String saveKurir(@ModelAttribute Kurir kurir) {
        kurirService.saveKurir(kurir);
        return "redirect:/kurir/manage";
    }

    // Hapus Data
    @GetMapping("/delete/{id}")
    public String deleteKurir(@PathVariable Long id) {
        kurirService.deleteKurir(id);
        return "redirect:/kurir/manage";
    }

    // Edit Data (Load Form)
    @GetMapping("/edit/{id}")
    public String editKurir(@PathVariable Long id, Model model) {
        Kurir existingKurir = kurirService.getKurirById(id);
        
        model.addAttribute("kurirList", kurirService.getAllKurir());
        model.addAttribute("newKurir", existingKurir); 
        
        return "admin_kurir_manage"; 
    }
}