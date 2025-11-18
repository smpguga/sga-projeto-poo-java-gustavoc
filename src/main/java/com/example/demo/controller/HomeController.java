package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Define a rota de acesso inicial (http://localhost:8080/)
    @GetMapping("/")
    public String index() {
        return "index"; // Vai procurar o arquivo index.html na pasta templates
    }
}
