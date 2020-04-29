package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "superhero")

public class SuperHero extends Civil{

    @ManyToMany
    @JoinTable (name = "abilite_superhero",
            joinColumns = @JoinColumn (name = "id_superhero"),
            inverseJoinColumns = @JoinColumn (name = "id_abilite"))

    List <Ability> listAbility;

    public List<Ability> getListAbility() {
        return listAbility;
    }

    public void setListAbility(List<Ability> listAbility) {
        this.listAbility = listAbility;
    }

}
