package com.projetjava.appli.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.List;
import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "civil")
public class Civil {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;
    @Temporal(TemporalType.DATE)
    private Date dateDeces;
    @Temporal(TemporalType.DATE)
    private Date dateModif;
    @Temporal(TemporalType.DATE)
    private Date dateAdd;

    @ManyToMany
    private List<Organisation> listeOrganisation;

    @OneToOne
    private Identification identifiant;

    public List<Organisation> getListeOrganisation() {
        return listeOrganisation;
    }

    public void setListeOrganisation(List<Organisation> listeOrganisation) {
        this.listeOrganisation = listeOrganisation;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }
}
