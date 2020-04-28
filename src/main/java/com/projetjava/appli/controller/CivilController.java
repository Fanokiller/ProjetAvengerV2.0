package com.projetjava.appli.controller;


import com.projetjava.appli.dao.IdentificationDAO;
import com.projetjava.appli.dao.OrganisationDAO;
import com.projetjava.appli.dao.PaysDAO;
import com.projetjava.appli.dao.CivilDAO;
import com.projetjava.appli.model.Civil;
import com.projetjava.appli.model.Identification;
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
    IdentificationDAO identificationDAO;


    @Autowired
    CivilDAO civilDAO;

    @Autowired
    PaysDAO paysDAO;

    @Autowired
    OrganisationDAO organisationDAO;

    @GetMapping("/liste-civil")
    public String listeCivil(Model model) {

        model.addAttribute("titre", "liste des civils");
        model.addAttribute("civils", civilDAO.findAll());
        model.addAttribute("pays",paysDAO.findAll());


        return "liste-civil";
    }

    @GetMapping({"/edit-civil", "/edit-civil/{id}"})
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
        model.addAttribute("organisations", organisationDAO.findAll());
        model.addAttribute("civil", civil);
        model.addAttribute("identification", identificationDAO.findAll());


        return "edit-civil";
    }

    @PostMapping("/edit-civil")

    public String editCivil(@ModelAttribute("civil") Civil civil){

        civil = civilDAO.saveAndFlush(civil);

        return "redirect:/liste-civil";
    }
    @GetMapping("/suppression-civil/{id}")
    public String delCivil(@PathVariable Integer id){
        civilDAO.deleteById(id);


        return "redirect:/liste-civil";
    }
}
