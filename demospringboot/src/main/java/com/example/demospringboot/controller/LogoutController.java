// Leticia Michelle Purba (8252401440)
package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Hapus Session
        request.getSession().invalidate(); 
        
        // Redirect ke Login
        return "redirect:/admin/login"; 
    }
}