package com.projetjava.appli.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean presenceSuperEvil;
    private int nbrCivilPresent;

    @ManyToMany
    private List<Nature> listeNature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Nature> getListeNature() {
        return listeNature;
    }

    public void setListeNature(List<Nature> listeNature) {
        this.listeNature = listeNature;
    }
}
