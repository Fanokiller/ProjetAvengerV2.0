package com.projetjava.appli.controller;


import com.projetjava.appli.dao.*;
import com.projetjava.appli.model.Ability;
import com.projetjava.appli.model.Adresse;
import com.projetjava.appli.model.SuperHero;
import com.projetjava.appli.model.SuperHero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SuperheroController {

    @Autowired
    CivilDAO civilDAO;

    @Autowired
    SuperHeroDAO superHeroDAO;

    @Autowired
    OrganisationDAO organisationDAO;

    @Autowired
    PaysDAO paysDAO;

    @Autowired
    AbilityDAO abilityDAO;

    @Autowired
    WeaknessDAO weaknessDAO;

    @GetMapping("/liste-superhero")
    public String listeSuperhero(Model model) {

        model.addAttribute("titre", "liste des Superheros");
        model.addAttribute("superheros", superHeroDAO.findAll());
        model.addAttribute("civil", civilDAO.findAll());
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("organisation", organisationDAO.findAll());

        return "liste-superhero";
    }

    @GetMapping({"/modo/edit-superhero", "/modo/edit-superhero/{id}"})
    public String editSuperHero(Model model, @PathVariable Optional <Integer> id) {

        SuperHero superHero;

        if(id.isPresent()){
            superHero = superHeroDAO.findById(id.get()).orElse(null);
        }else {
            superHero = new SuperHero();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit superHeros" : "Nouvel superHero");
        model.addAttribute("superhero", superHero);
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("organisation", organisationDAO.findAll());
        model.addAttribute("civil", civilDAO.findAll());
        model.addAttribute("ability", abilityDAO.findAll());
        model.addAttribute("weakness", weaknessDAO.findAll());

        return "edit-superHero";
    }
    @PostMapping("/modo/edit-superhero")
    public String editSuperhero(@ModelAttribute("superhero") SuperHero superhero){

        superhero = superHeroDAO.saveAndFlush(superhero);

        return "redirect:/liste-superhero";
    }

    @GetMapping("/admin/suppression-superhero/{id}")
    public String delSuperhero(@PathVariable Integer id){
        superHeroDAO.deleteById(id);


        return "redirect:/liste-superhero";
    }
}


