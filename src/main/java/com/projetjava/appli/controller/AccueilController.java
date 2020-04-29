package com.projetjava.appli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AccueilController {

    @GetMapping("/")
    public String accueil(Model model) {


        model.addAttribute("titre", "Accueil");

        return "accueil";
    }

    @GetMapping("/admin/hello")
    public String hello(Model model){
        model.addAttribute("hello", "Hello");

        return "accueil";
    }
}
