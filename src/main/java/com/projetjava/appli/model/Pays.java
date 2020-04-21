package com.projetjava.appli.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "pays")
@EntityListeners(AuditingEntityListener.class)
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPays;
    private String nom;

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}

