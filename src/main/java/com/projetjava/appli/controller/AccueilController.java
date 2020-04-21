package com.projetjava.appli.controller;

import com.projetjava.appli.dao.UtilisateurDAO;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccueilController {

    @GetMapping("/")
    public String accueil(Model model) {


        model.addAttribute("titre", "Accueil");

        return "accueil";
    }
}
