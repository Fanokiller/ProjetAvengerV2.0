package com.projetjava.appli.controller;

import com.projetjava.appli.dao.IdentificationDAO;
import com.projetjava.appli.model.Identification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IdentificationController {

    @Autowired
    IdentificationDAO identificationDAO;

    @GetMapping("/inscription-test")
    public String inscription(Model model) {


        model.addAttribute("titre", "Inscription");
        model.addAttribute("identifiant", identificationDAO.findAll());

        return "Inscription";
    }

    @GetMapping("/connexion")
    public String connexion(Model model) {


        model.addAttribute("titre", "Connexion");
        model.addAttribute("identifiant", identificationDAO);

        return "Connexion";
    }
}
