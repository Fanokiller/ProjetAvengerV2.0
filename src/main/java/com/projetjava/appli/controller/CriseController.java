package com.projetjava.appli.controller;


import com.projetjava.appli.dao.CriseDAO;
import com.projetjava.appli.model.Crise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CriseController {

    @Autowired
    CriseDAO criseDAO;

    @GetMapping("/liste-crise")
    public String listeCrise(Model model) {


        model.addAttribute("titre", "liste des crises");
        model.addAttribute("crises", criseDAO.findAll());

        return "liste-crise";
    }

    @GetMapping({"/edit-crise", "/edit-crise/{id}"})
    public String editCrise(Model model, @PathVariable Optional<Integer> id) {


        Crise crise;

        if(id.isPresent()){
            crise = criseDAO.findById(id.get()).orElse(null);
        }else {
            crise = new Crise();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Crises" : "Nouvelle crise");
        model.addAttribute("crise", crise);

        return "edit-crise";
    }

    @PostMapping("/edit-crise")
    public String editCrise(@ModelAttribute("crise") Crise crise){

        crise = criseDAO.saveAndFlush(crise);

        return "redirect:/liste-crise";
    }

    @GetMapping("/suppression-crise/{id}")
    public String delCrise(@PathVariable Integer id){
        criseDAO.deleteById(id);

        return "redirect:/liste-crise";
    }
}