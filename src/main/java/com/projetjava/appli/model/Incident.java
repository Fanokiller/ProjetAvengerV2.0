package com.projetjava.appli.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table( name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIncident;
    private String adresse;
    private boolean presenceSuperEvil;
    private int nbrCivilPresent;
    private String name;


    @ManyToOne
    @JoinColumn(name = "id_nature")
    private Nature nature;
    //



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }




    public boolean isPresenceSuperEvil() {
        return presenceSuperEvil;
    }

    public void setPresenceSuperEvil(boolean presenceSuperEvil) {
        this.presenceSuperEvil = presenceSuperEvil;
    }

    public int getNbrCivilPresent() {
        return nbrCivilPresent;
    }

    public void setNbrCivilPresent(int nbrCivilPresent) {
        this.nbrCivilPresent = nbrCivilPresent;
    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateIncident() {
        return dateIncident;
    }

    public void setDateIncident(Date dateIncident) {
        this.dateIncident = dateIncident;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
