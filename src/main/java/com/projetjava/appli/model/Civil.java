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
    protected int id;
    protected String name;
    protected String nickname;
    protected String heroName;
    protected String evilName;
    @Temporal(TemporalType.DATE)
    protected Date dateDeces;
    @Temporal(TemporalType.DATE)
    protected Date dateModif;
    @Temporal(TemporalType.DATE)
    protected Date dateAdd;

    @ManyToMany
    @JoinTable(name = "membre_organisation",
            joinColumns = @JoinColumn(name = "id_civil"), /*mettre id civil*/
            inverseJoinColumns = @JoinColumn(name = "id_organisation"))
    protected List<Organisation> listeOrganisation;

    @ManyToOne
    @JoinColumn(name = "id_pays")
    protected Pays pays;

    @OneToOne
    protected Identification identifiant;

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

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getEvilName() {
        return evilName;
    }

    public void setEvilName(String evilName) {
        this.evilName = evilName;
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

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Identification getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Identification identifiant) {
        this.identifiant = identifiant;
    }
}
