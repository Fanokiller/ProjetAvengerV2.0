package com.projetjava.appli.controller;
import com.projetjava.appli.dao.*;
import com.projetjava.appli.model.Incident;
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
public class IncidentController {

    @Autowired
    IncidentDAO incidentDAO;

    @Autowired

    CivilDAO civilDAO;

    @Autowired

    OrganisationDAO organisationDAO;

    @Autowired

    InformationDAO informationDAO;

    @Autowired

    NatureDAO natureDAO;




    @GetMapping("/liste-incident")
    public String listeIncident(Model model) {


        model.addAttribute("titre", "liste des incident");
        model.addAttribute("incidents", incidentDAO.findAll());

        return "liste-incident";
    }

    @GetMapping({"/edit-incident", "/edit-incident /{id}"})
    public String editIncident(Model model, @PathVariable Optional<Integer> id) {


        Incident incident;

        if(id.isPresent()){
            incident = incidentDAO.findById(id.get()).orElse(null);
        }else {
            incident = new Incident();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Incidents" : "Nouvel incident");
        model.addAttribute("incident",incident);
        model.addAttribute("civil", civilDAO.findAll());
        model.addAttribute("informations", informationDAO.findAll());
        model.addAttribute("organisations", organisationDAO.findAll());


        return "edit-incident";
    }

    @PostMapping("/edit-incident")
    public String editIncident(@ModelAttribute("incident") Incident incident){

        incident = incidentDAO.saveAndFlush(incident);

        return "redirect:/liste-incident";
    }


    @GetMapping("/suppression-incident/{id}")
    public String delIncident(@PathVariable Integer id){
        incidentDAO.deleteById(id);

        return "redirect:/liste-incident";
    }
}
