package com.projetjava.appli.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@EntityListeners(AuditingEntityListener.class)
@Entity
@Table (name = "user")
public class Utilisateur {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String role;


    @ManyToOne
    @JoinColumn(name = "id_pays")
    private Pays pays;

    @ManyToMany
    @JoinTable(name = "membre_organisation",
            joinColumns = @JoinColumn(name = "id_utilisateur"), /*mettre id civil*/
            inverseJoinColumns = @JoinColumn(name = "id_organisation"))
    private List<Organisation> listeOrganisation;

    public List<Organisation> getListeOrganisation() {
        return listeOrganisation;
    }

    public void setListeOrganisation(List<Organisation> listeOrganisation) {
        this.listeOrganisation = listeOrganisation;
    }

    public Utilisateur(){
    }


    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}





