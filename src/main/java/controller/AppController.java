package com.sistema.sistema_produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/app/home")
    public String appHome() {
        return "app/home";
    }
}
