package com.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // ← ESTA LINHA É OBRIGATÓRIA!
public class HomeController {
    
    @GetMapping("/")  // ← MAPEIA http://localhost:8080/
    public String home() {
        return "🏠 API Biblioteca Online!";
    }
    
    @GetMapping("/health")  // ← MAPEIA http://localhost:8080/health
    public String health() {
        return "✅ Status: ONLINE";
    }
    
    @GetMapping("/sobre")  // ← MAPEIA http://localhost:8080/sobre  
    public String sobre() {
        return "API Biblioteca - Trabalho Spring Boot";
    }
}