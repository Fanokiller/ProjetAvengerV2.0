package com.projetjava.appli.controller;

import com.projetjava.appli.dao.OrganisationDAO;
import com.projetjava.appli.dao.PaysDAO;
import com.projetjava.appli.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class OrganisationController {

    @Autowired
    OrganisationDAO organisationDAO;

    @Autowired

    PaysDAO paysDAO;


    @GetMapping("/liste-organisation")
    public String listeOrganisation(Model model) {


        model.addAttribute("titre", "liste des organisations");
        model.addAttribute("organisations", organisationDAO.findAll());

        return "liste-organisation";
    }

    @GetMapping({"/edit-organisation", "/edit-organisation/{id}"})
    public String editOrganisation(Model model, @PathVariable Optional<Integer> id) {


        Organisation organisation;

        if(id.isPresent()){
            organisation = organisationDAO.findById(id.get()).orElse(null);
        }else {
            organisation = new Organisation();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Organisations" : "Nouvel organisation");
        model.addAttribute("pays", paysDAO.findAll());

        model.addAttribute("organisation", organisation);

        return "edit-organisation";
    }

    @PostMapping("/edit-organisation")
    public String editOrganisation(@ModelAttribute("organisation") Organisation organisation){

        organisation = organisationDAO.saveAndFlush(organisation);

        return "redirect:/liste-organisation";
    }

    @GetMapping("/suppression-organisation/{id}")
    public String delOrganisation(@PathVariable Integer id){
        organisationDAO.deleteById(id);

        return "redirect:/liste-organisation";
    }
}
