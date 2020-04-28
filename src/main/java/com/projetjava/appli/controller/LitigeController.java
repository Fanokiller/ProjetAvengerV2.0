package com.projetjava.appli.controller;

import com.projetjava.appli.dao.LitigeDAO;
import com.projetjava.appli.model.Litige;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LitigeController {

    @Autowired
    LitigeDAO litigeDAO;

    @GetMapping("/liste-litige")
    public String listeLitige(Model model) {


        model.addAttribute("titre", "liste des litiges");
        model.addAttribute("litiges", litigeDAO.findAll());

        return "liste-litige";
    }

    @GetMapping({"/edit-litige", "/edit-litige/{id}"})
    public String editLitige(Model model, @PathVariable Optional<Integer> id) {


        Litige litige;

        if(id.isPresent()){
            litige = litigeDAO.findById(id.get()).orElse(null);
        }else {
            litige = new Litige();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Litiges" : "Nouvelle litige");
        model.addAttribute("litige", litige);

        return "edit-litige";
    }

    @PostMapping("/edit-litige")
    public String editLitige(@ModelAttribute("litige") Litige litige){

        litige = litigeDAO.saveAndFlush(litige);

        return "redirect:/liste-litige";
    }

    @GetMapping("/suppression-litige/{id}")
    public String delLitige(@PathVariable Integer id){
        litigeDAO.deleteById(id);

        return "redirect:/liste-litige";
    }
}

