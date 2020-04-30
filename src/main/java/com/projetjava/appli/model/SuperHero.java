package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "superhero")

public class SuperHero {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String heroName;
    private String email;


    @OneToOne
    @JoinColumn(name = "id_pays")
    private Pays pays;

    @OneToOne
    @JoinColumn(nullable = true, name = "id_civil")
    private Civil civil;

    @ManyToMany
    @JoinTable(name = "membre_organisation",
            joinColumns = @JoinColumn(name = "id_superHero"),
            inverseJoinColumns = @JoinColumn(name = "id_organisation"))
    private List<Organisation> listeOrganisation;

    @ManyToMany
    @JoinTable (name = "abilite_superhero",
            joinColumns = @JoinColumn (name = "id_superhero"),
            inverseJoinColumns = @JoinColumn (name = "id_abilite"))
    private List<Ability> listAbility;

    @ManyToMany
    @JoinTable (name = "weakness_superhero",
            joinColumns = @JoinColumn (name = "id_superhero"),
            inverseJoinColumns = @JoinColumn (name = "id_abilite"))
    private List<Weakness> listWeakness;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Civil getCivil() {
        return civil;
    }

    public void setCivil(Civil civil) {
        this.civil = civil;
    }

    public List<Organisation> getListeOrganisation() {
        return listeOrganisation;
    }

    public void setListeOrganisation(List<Organisation> listeOrganisation) {
        this.listeOrganisation = listeOrganisation;
    }

    public List<Ability> getListAbility() {
        return listAbility;
    }

    public void setListAbility(List<Ability> listAbility) {
        this.listAbility = listAbility;
    }

    public List<Weakness> getListWeakness() {
        return listWeakness;
    }

    public void setListWeakness(List<Weakness> listWeakness) {
        this.listWeakness = listWeakness;
    }
}
