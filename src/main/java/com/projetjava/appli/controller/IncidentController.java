package com.projetjava.appli.controller;
import com.projetjava.appli.dao.*;
import com.projetjava.appli.model.*;
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
    NatureDAO natureDAO;





    @GetMapping("/liste-incident")
    public String listeIncident(Model model) {


        model.addAttribute("titre", "liste des incident");
        model.addAttribute("incidents", incidentDAO.findAll());
        model.addAttribute("natures", natureDAO.findAll());

        return "liste-incident";
    }

    @GetMapping({"/modo/edit-incident", "/modo/edit-incident /{id}"})
    public String editIncident(Model model, @PathVariable Optional<Integer> id) {


        Incident incident;
        Organisation organisation;
        Nature nature;

        Identification identification;

        if(id.isPresent()){
            incident = incidentDAO.findById(id.get()).orElse(null);
        }else {
            incident = new Incident();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Incidents" : "Nouvel incident");
        model.addAttribute("incident",incident);
        model.addAttribute("civil", civilDAO.findAll());
        model.addAttribute("organisations", organisationDAO.findAll());
        model.addAttribute("nature", natureDAO.findAll());


        return "edit-incident";
    }

    @PostMapping("/modo/edit-incident")
    public String editIncident(@ModelAttribute("incident") Incident incident){

        incident = incidentDAO.saveAndFlush(incident);

        return "redirect:/liste-incident";
    }


    @GetMapping("/admin/suppression-incident/{id}")
    public String delIncident(@PathVariable Integer id){
        incidentDAO.deleteById(id);

        return "redirect:/liste-incident";
    }
}
