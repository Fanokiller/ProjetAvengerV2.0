package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;

@Table(name = "identification")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private boolean isAdmin;







    @OneToOne (mappedBy = "identification")
    private Civil identifiantCivil;

    @OneToOne (mappedBy = "identifiant")
    private Organisation identifiantOrganisation;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Civil getIdentifiantCivil() {
        return identifiantCivil;
    }

    public void setIdentifiantCivil(Civil identifiantCivil) {
        this.identifiantCivil = identifiantCivil;
    }

    public Organisation getIdentifiantOrganisation() {
        return identifiantOrganisation;
    }

    public void setIdentifiantOrganisation(Organisation identifiantOrganisation) {
        this.identifiantOrganisation = identifiantOrganisation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
