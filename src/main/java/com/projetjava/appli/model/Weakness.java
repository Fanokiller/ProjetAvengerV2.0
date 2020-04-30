package com.projetjava.appli.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "weakness")
public class Weakness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String name;

    @ManyToOne
    @JoinColumn (name = "id_superhero")
    @JoinColumn (name = "id_superevil")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "listWeakness")
    private Collection<SuperHero> superHeroes;

    public Collection<SuperHero> getSuperHeroes() {
        return superHeroes;
    }

    public void setSuperHeroes(Collection<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
    }

}
