package com.projetjava.appli.dao;

import com.projetjava.appli.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseDAO extends JpaRepository<Adresse, Integer> {
}
