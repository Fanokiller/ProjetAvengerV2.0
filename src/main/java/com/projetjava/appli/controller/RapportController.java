package com.projetjava.appli.controller;

import com.projetjava.appli.dao.IncidentDAO;
import com.projetjava.appli.dao.MissionDAO;
import com.projetjava.appli.dao.PaysDAO;
import com.projetjava.appli.dao.RapportDAO;
import com.projetjava.appli.model.Incident;
import com.projetjava.appli.model.Mission;
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

    @Autowired
    MissionDAO missionDAO;

    @Autowired
    IncidentDAO incidentDAO;






    @GetMapping("/liste-rapport")
    public String listeRapport(Model model) {


        model.addAttribute("titre", "liste des rapports");
        model.addAttribute("rapports", rapportDAO.findAll());
        model.addAttribute("mission", missionDAO.findAll());
        return "liste-rapport";
    }

    @GetMapping({"/lancer-rapport/{id}"})
    public String lancerRapport(Model model, @PathVariable Optional<Integer> id) {


        Mission mission = missionDAO.findById(id.get()).orElse(null);
        Rapport rapport = new Rapport();
        rapport.setMission(mission);

        model.addAttribute("titre", "Nouveau rapport d'apres la mission :  " + mission.getName() );
        model.addAttribute("mission", missionDAO.findAll());


        model.addAttribute("rapport",rapport);


        return "edit-rapport";
    }


    @GetMapping("{/modo/edit-rapport/{id}")
    public String editRapport(Model model, @PathVariable Optional<Integer> id) {

        Mission mission;
        Rapport rapport;


        rapport = rapportDAO.findById(id.get()).orElse(null);
        mission = missionDAO.findById(id.get()).orElse(null);


        model.addAttribute("titre", "Edit Rapport ");
        model.addAttribute("mission", missionDAO.findAll());


        model.addAttribute("mission",mission);
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

