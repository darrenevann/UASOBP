// Leticia Michelle Purba (8252401440)

package com.example.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demospringboot.entity.Admin;
import com.example.demospringboot.entity.KirimanReguler;
import com.example.demospringboot.entity.LoginRequest;
import com.example.demospringboot.service.AdminService;
import com.example.demospringboot.service.KirimanService;
import com.example.demospringboot.service.KurirService; 

import jakarta.servlet.http.HttpServletRequest;

@Controller 
@RequestMapping("/admin") 
public class AdminMvcController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private KirimanService kirimanService;

    @Autowired
    private KurirService kurirService;
    
    // Halaman Login
    @GetMapping("/login")
    public String showAdminLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest()); 
        return "admin_login"; 
    }
    
    // Proses Login
    @PostMapping("/login")
    public String loginAdmin(@ModelAttribute LoginRequest loginRequest, HttpServletRequest request) {
        Admin admin = adminService.loginAdmin(
            loginRequest.getUsername(), 
            loginRequest.getPassword()
        );

        if (admin != null) {
            request.getSession().setAttribute("Admin", admin); 
            return "redirect:/admin/dashboard"; 
        } else {
            return "redirect:/admin/login?error"; 
        }
    }
    
    // Dashboard
    @GetMapping("/dashboard")
    public String adminDashboard(Model model, HttpServletRequest request) {
        // Cek Session
        if (request.getSession().getAttribute("Admin") == null) {
            return "redirect:/admin/login"; 
        }
        
        // Load Data Dashboard
        model.addAttribute("kirimanList", kirimanService.getAllKiriman());
        model.addAttribute("kirimanBaru", new KirimanReguler()); 
        model.addAttribute("kurirList", kurirService.getAllKurir());
        
        return "admin_dashboard";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate(); 
        return "redirect:/admin/login"; 
    }
}