package com.projetjava.appli.controller;

import com.projetjava.appli.dao.OrganisationDAO;
import com.projetjava.appli.dao.PaysDAO;
import com.projetjava.appli.dao.UtilisateurDAO;
import com.projetjava.appli.model.Role;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UtilisateurController {

    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;

    @Autowired
    PaysDAO paysDAO;

    @Autowired
    OrganisationDAO organisationDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/liste-utilisateur")
    public String listeUtilisateur(Model model) {

        model.addAttribute("titre", "liste des utilisateurs");
        model.addAttribute("utilisateurs", utilisateurDAO.findAll());

        return "liste-utilisateur";
    }

    @GetMapping("/inscription")
    public String inscription(Model model){

        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String ajoutUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur){
        Role role = new Role();
        role.setId(1);
        utilisateur.setRole(role);
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateurDAO.saveAndFlush(utilisateur);

        return "redirect:/inscription-reussi";
    }
    @GetMapping("/inscription-reussi")
    public String inscriptionReussi(){

        return "inscription-reussi";
    }

    @GetMapping("/inscription-echec")
    public String inscriptionEchec(){

        return "inscription-echec";
    }


    @GetMapping({"/modo/edit-utilisateur", "/modo/edit-utilisateur/{id}"})
    public String editUtilisateur(Model model, @PathVariable Optional <Integer> id) {

        Utilisateur utilisateur;

        if(id.isPresent()){
            utilisateur = utilisateurDAO.findById(id.get()).orElse(null);
        }else {
            utilisateur = new Utilisateur();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit utilisateurs" : "Nouvel utilisateur");
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("organisations", organisationDAO.findAll());
        model.addAttribute("utilisateur", utilisateur);

        return "edit-utilisateur";
    }

    @PostMapping("/modo/edit-utilisateur")
    public String editUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur){
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateur = utilisateurDAO.saveAndFlush(utilisateur);

        return "redirect:/liste-utilisateur";
    }

    @DeleteMapping("suppression-utilisateur/{id}")
    public String delUtilisateure(@PathVariable Integer id) {
        utilisateurDAO.deleteById(id);
        return "redirect:/liste-utilisateur";
    }

    @GetMapping("/admin/suppression-utilisateur/{id}")
    public String delUtilisateur(@PathVariable Integer id){
        utilisateurDAO.deleteById(id);

        return "redirect:/liste-utilisateur";
    }
}
