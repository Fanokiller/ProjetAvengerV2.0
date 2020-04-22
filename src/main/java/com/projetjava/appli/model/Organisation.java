package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "organistaion")
public class Organisation {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private int id;
    private String name;
    private String socialSiege;

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
