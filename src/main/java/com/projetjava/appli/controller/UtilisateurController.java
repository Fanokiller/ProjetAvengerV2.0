package com.projetjava.appli.controller;

import com.projetjava.appli.dao.CountryDAO;
import com.projetjava.appli.dao.UserDAO;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UtilisateurController {

    @Autowired
    UserDAO utilisateurDAO;

    @Autowired
    CountryDAO paysDAO;

    @GetMapping("/liste-utilisateur")
    public String listeUtilisateur(Model model) {

        model.addAttribute("titre", "liste des utilisateurs");
        model.addAttribute("utilisateurs", utilisateurDAO.findAll());

        return "liste-utilisateur";
    }

    @GetMapping({"/edit-utilisateur", "/edit-utilisateur/{id}"})
    public String editUtilisateur(Model model, @PathVariable Optional <Integer> id) {

        Utilisateur utilisateur;

        if(id.isPresent()){
            utilisateur = utilisateurDAO.findById(id.get()).orElse(null);
        }else {
            utilisateur = new Utilisateur();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit utilisateurs" : "Nouvel utilisateur");
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("utilisateur", utilisateur);

        return "edit-utilisateur";
    }

    @PostMapping("/edit-utilisateur")
    public String editUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur){

        utilisateur = utilisateurDAO.saveAndFlush(utilisateur);

        return "redirect:/liste-utilisateur";
    }
}
