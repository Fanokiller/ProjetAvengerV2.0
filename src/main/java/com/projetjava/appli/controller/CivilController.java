package com.projetjava.appli.controller;


import com.projetjava.appli.dao.*;
import com.projetjava.appli.model.Civil;
import com.projetjava.appli.model.Identification;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
    public class CivilController {

    @Autowired
    IdentificationDAO identificationDAO;

    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;

    @Autowired
    CivilDAO civilDAO;

    @Autowired
    PaysDAO paysDAO;

    @Autowired
    OrganisationDAO organisationDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/liste-civil")
    public String listeCivil(Model model, Principal principal) {

        Utilisateur utilisateur = utilisateurDAO.findByEmail(principal.getName()).orElse(null);
        model.addAttribute("titre", "liste des civils");
        model.addAttribute("civils", civilDAO.findAll());
        model.addAttribute("pays",paysDAO.findAll());
        model.addAttribute("role", utilisateur != null ? utilisateur.getRole().getName():null);

        return "civil/liste-civil";
    }

    @GetMapping({"/modo/edit-civil", "/modo/edit-civil/{id}"})
    public String editCivil(Model model, @PathVariable Optional <Integer> id) {

        Civil civil;
        Identification identification;

        if(id.isPresent()){
            civil = civilDAO.findById(id.get()).orElse(null);
        }else {
            civil = new Civil();
        }


        model.addAttribute("titre", id.isPresent() ? "Edit civils" : "Nouvel civil");
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("roles", roleDAO.findAll());
        model.addAttribute("organisations", organisationDAO.findAll());
        model.addAttribute("civil", civil);
        model.addAttribute("identification", identificationDAO.findAll());


        return "civil/edit-civil";
    }

    @PostMapping("/modo/edit-civil")

    public String editCivil(@ModelAttribute("civil") Civil civil){
        civil.setPassword(passwordEncoder.encode(civil.getPassword()));
        civil = civilDAO.saveAndFlush(civil);

        return "redirect:/liste-civil";
    }
    @GetMapping("/admin/suppression-civil/{id}")
    public String delCivil(@PathVariable Integer id){
        civilDAO.deleteById(id);


        return "redirect:/liste-civil";
    }
}
