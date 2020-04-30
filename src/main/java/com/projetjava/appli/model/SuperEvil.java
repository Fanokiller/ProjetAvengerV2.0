package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "superevil")

public class SuperEvil {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String evilName;
    private String email;


    @OneToOne
    @JoinColumn(name = "id_pays")
    private Pays pays;

    @ManyToMany
    @JoinTable(name = "membre_organisation",
            joinColumns = @JoinColumn(name = "id_superEvil"),
            inverseJoinColumns = @JoinColumn(name = "id_organisation"))
    protected List<Organisation> listeOrganisation;

    @ManyToMany
    @JoinTable (name = "abilite_superevil",
            joinColumns = @JoinColumn (name = "id_superevil"),
            inverseJoinColumns = @JoinColumn (name = "id_abilite"))
    private List<Ability> listAbility;

    @ManyToMany
    @JoinTable (name = "weakness_superevil",
            joinColumns = @JoinColumn (name = "id_superevil"),
            inverseJoinColumns = @JoinColumn (name = "id_abilite"))
    private List<Weakness> listWeakness;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvilName() {
        return evilName;
    }

    public void setEvilName(String evilName) {
        this.evilName = evilName;
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
