package com.projetjava.appli.controller;

import com.projetjava.appli.dao.CivilDAO;
import com.projetjava.appli.dao.PaysDAO;

import com.projetjava.appli.dao.PaysDAO;
import com.projetjava.appli.dao.UtilisateurDAO;
import com.projetjava.appli.model.Civil;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
    public class CivilController {

    @Autowired
    CivilDAO civilDAO;

    @Autowired
    PaysDAO paysDAO;

    @GetMapping("/liste-civil")
    public String listeCivil(Model model) {

        model.addAttribute("titre", "liste des civil");
        model.addAttribute("civils", civilDAO.findAll());

        return "liste-civil";
    }

    @GetMapping({"/edit-civil", "/edit-civil/{id}"})
    public String editCivil(Model model, @PathVariable Optional <Integer> id) {

        Civil civil;

        if(id.isPresent()){
            civil = civilDAO.findById(id.get()).orElse(null);
        }else {
            civil = new Civil();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit civil" : "Nouveau civil");
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("civil", civil);

        return "edit-civil";
    }

    @PostMapping("/edit-civil")
    public String editUtilisateur(@ModelAttribute("civil") Civil civil){

        civil = civilDAO.saveAndFlush(civil);

        return "redirect:/liste-civil";
    }
}
