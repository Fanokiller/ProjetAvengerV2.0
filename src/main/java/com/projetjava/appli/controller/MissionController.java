package com.projetjava.appli.controller;

import com.projetjava.appli.dao.IncidentDAO;
import com.projetjava.appli.dao.MissionDAO;
import com.projetjava.appli.dao.OrganisationDAO;
import com.projetjava.appli.dao.PaysDAO;
import com.projetjava.appli.model.Incident;
import com.projetjava.appli.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MissionController {
    @Autowired
    MissionDAO missionDAO;

    @Autowired
    PaysDAO paysDAO;

    @Autowired
    IncidentDAO incidentDAO;

    @Autowired
    OrganisationDAO organisationDAO;

    @GetMapping("/liste-mission")
    public String listeMission(Model model) {


        model.addAttribute("titre", "liste des missions");
        model.addAttribute("missions", missionDAO.findAll());
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("organisation", organisationDAO.findAll());;

        return "liste-mission";
    }

    @GetMapping({"/lancer-mission/{id}"})
    public String lancerMission(Model model, @PathVariable Optional<Integer> id) {


        Incident incident = incidentDAO.findById(id.get()).orElse(null);
        Mission mission = new Mission();
        mission.setIncident(incident);

        model.addAttribute("titre", "Nouvelle mission d'aprés l'incident :  " + incident.getName() );
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("organisation", organisationDAO.findAll());

        model.addAttribute("mission",mission);


        return "edit-mission";
    }
    @GetMapping({"modo/edit-mission/{id}"})
    public String editMission(Model model, @PathVariable Optional<Integer> id) {


        Mission mission = missionDAO.findById(id.get()).orElse(null);

        model.addAttribute("titre",  "Edit Missions ");
        model.addAttribute("pays", paysDAO.findAll());
        model.addAttribute("organisation", organisationDAO.findAll());

        model.addAttribute("mission", mission);

        return "edit-mission";
    }

    @PostMapping("/modo/edit-mission")
    public String editMission(@ModelAttribute("mission") Mission mission){




        mission = missionDAO.saveAndFlush(mission);

        return "redirect:/liste-mission";
    }

    @GetMapping("/admin/suppression-mission/{id}")
    public String delMission(@PathVariable Integer id){
        missionDAO.deleteById(id);

        return "redirect:/liste-mission";
    }
}

