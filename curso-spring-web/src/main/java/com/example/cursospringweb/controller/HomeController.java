package com.example.cursospringweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "forward:/app/index"; //cambiar forward por redirect también funciona. (Solo con rutas del proyecto) Forward no altera el link
    }
}
