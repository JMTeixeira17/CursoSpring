package com.example.cursospringweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/string") //Ruta real del método
    public String param(@RequestParam(name="texto",defaultValue = "No existe el texto") String texto, Model model){
        model.addAttribute("resultado","El texto enviado es: "+texto);
        return "param/ver"; //Ruta de la carpeta y archivo
    }

    @GetMapping("/")
    public String index(){
        return "param/index";
    }

    @GetMapping("/mix-params") //Ruta real del método
    public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model){
        model.addAttribute("resultado","El saludo enviado es: "+saludo+ " y el numero es" + "'" + numero + "'");
        return "param/ver"; //Ruta de la carpeta y archivo
    }

    @GetMapping("/mix-params-request") //Ruta real del método
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("resultado","El saludo enviado es: "+saludo+ " y el numero es" + "'" + numero + "'");
        return "param/ver"; //Ruta de la carpeta y archivo
    }




}

