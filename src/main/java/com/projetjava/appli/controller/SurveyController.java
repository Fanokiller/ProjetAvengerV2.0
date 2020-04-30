package com.projetjava.appli.controller;

import com.projetjava.appli.dao.SuperHeroDAO;
import com.projetjava.appli.dao.SurveyDAO;
import com.projetjava.appli.model.SuperHero;
import com.projetjava.appli.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SurveyController {
    @Autowired
    SurveyDAO surveyDAO;

    @Autowired
    SuperHeroDAO superHeroDAO;


    @GetMapping("/liste-survey")
    public String listeSurvey(Model model) {


        model.addAttribute("titre", "liste des surveys");
        model.addAttribute("surveys", surveyDAO.findAll());
        model.addAttribute("superhero", superHeroDAO.findAll());

        return "liste-survey";
    }

    @GetMapping({"/modo/edit-survey", "/modo/edit-survey/{id}"})
    public String editSurvey(Model model, @PathVariable Optional<Integer> id) {


        Survey survey;

        if(id.isPresent()){
            survey = surveyDAO.findById(id.get()).orElse(null);
        }else {
            survey = new Survey();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Surveys" : "Nouveau survey");
        model.addAttribute("survey", survey);
        model.addAttribute("superhero", superHeroDAO.findAll());
        model.addAttribute("surveys", surveyDAO.findAll());



        return "edit-survey";
    }

    @PostMapping("/modo/edit-survey")
    public String editSurvey(@ModelAttribute("survey") Survey survey){

        survey = surveyDAO.saveAndFlush(survey);

        return "redirect:/liste-survey";
    }

    @GetMapping("/admin/suppression-survey/{id}")
    public String delSurvey(@PathVariable Integer id){
        surveyDAO.deleteById(id);

        return "redirect:/liste-survey";
    }
}

