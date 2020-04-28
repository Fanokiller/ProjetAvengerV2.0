package com.projetjava.appli.controller;

import com.projetjava.appli.dao.RapportDAO;
import com.projetjava.appli.model.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RapportController {
    @Autowired
    RapportDAO rapportDAO;



    @GetMapping("/liste-rapport")
    public String listeRapport(Model model) {


        model.addAttribute("titre", "liste des rapports");
        model.addAttribute("rapports", rapportDAO.findAll());

        return "liste-rapport";
    }

    @GetMapping({"/modo/edit-rapport", "/modo/edit-rapport/{id}"})
    public String editRapport(Model model, @PathVariable Optional<Integer> id) {


        Rapport rapport;

        if(id.isPresent()){
            rapport = rapportDAO.findById(id.get()).orElse(null);
        }else {
            rapport = new Rapport();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Rapports" : "Nouveau rapport");
        model.addAttribute("rapport", rapport);

        return "edit-rapport";
    }

    @PostMapping("/modo/edit-rapport")
    public String editRapport(@ModelAttribute("rapport") Rapport rapport){

        rapport = rapportDAO.saveAndFlush(rapport);

        return "redirect:/liste-rapport";
    }

    @GetMapping("/admin/suppression-rapport/{id}")
    public String delRapport(@PathVariable Integer id){
        rapportDAO.deleteById(id);

        return "redirect:/liste-rapport";
    }
}

