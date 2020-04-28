package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "organisation")
public class Organisation {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private int id;
    private String name;
    private String socialSiege;

    @OneToOne
    @JoinColumn(name = "id_pays")
    protected Pays pays;

    @ManyToOne
    private Civil dirigeant;

    @ManyToMany(mappedBy = "listeOrganisation")
    private List<Civil> listeMembre;

    @OneToOne
    private Identification identifiant;

    public Civil getDirigeant() {
        return dirigeant;
    }

    public void setDirigeant(Civil dirigeant) {
        this.dirigeant = dirigeant;
    }


    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Civil> getListeMembre() {
        return listeMembre;
    }

    public void setListeMembre(List<Civil> listeMembre) {

        this.listeMembre = listeMembre;
    }

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

    public String getSocialSiege() {
        return socialSiege;
    }

    public void setSocialSiege(String socialSiege) {
        this.socialSiege = socialSiege;
    }
}
