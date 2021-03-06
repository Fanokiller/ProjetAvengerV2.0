package com.projetjava.appli.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "adresse")
public class Adresse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
    private int postalNumber;
    private String street;
    private int number;

    @ManyToOne
    @JoinColumn (name = "id_civil")
    private Civil civil;

    @ManyToOne
    @JoinColumn (name = "id_superhero")
    private SuperHero superHero;

    public Civil getCivil() {
        return civil;
    }

    public void setCivil(Civil civil) {
        this.civil = civil;
    }

    public SuperHero getSuperHero() {
        return superHero;
    }

    public void setSuperHero(SuperHero superHero) {
        this.superHero = superHero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(int postalNumber) {
        this.postalNumber = postalNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
