package com.projetjava.appli.controller;

import com.projetjava.appli.dao.CivilDAO;
import com.projetjava.appli.dao.SuperEvilDAO;
import com.projetjava.appli.model.SuperEvil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SuperevilController {
    @Autowired
    CivilDAO civilDAO;

    @Autowired
    SuperEvilDAO superevilDAO;

    @GetMapping("/liste-superevil")
    public String listeSuperevil(Model model) {

        model.addAttribute("titre", "liste des Superevils");
        model.addAttribute("superevils", superevilDAO.findAll());
        model.addAttribute("civil", civilDAO.findAll());

        return "liste-superevil";
    }

    @GetMapping({"/edit-superevil", "/edit-superevil/{id}"})
    public String editSuperevil(Model model, @PathVariable Optional<Integer> id) {

        SuperEvil superevil;

        if(id.isPresent()){
            superevil = superevilDAO.findById(id.get()).orElse(null);
        }else {
            superevil = new SuperEvil();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit superevils" : "Nouvel superevil");
        model.addAttribute("superevil", superevil);

        return "edit-superevil";
    }
    @PostMapping("/edit-superevil")
    public String editSuperevil(@ModelAttribute("superevil") SuperEvil superevil){

        superevil = superevilDAO.saveAndFlush(superevil);

        return "redirect:/liste-superevil";
    }

    @GetMapping("/suppression-superevil/{id}")
    public String delSuperevil(@PathVariable Integer id){
        superevilDAO.deleteById(id);


        return "redirect:/liste-superevil";
    }
}
