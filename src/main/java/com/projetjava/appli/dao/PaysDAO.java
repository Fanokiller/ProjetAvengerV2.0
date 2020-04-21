package com.projetjava.appli.dao;

import com.projetjava.appli.model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysDAO extends JpaRepository<Pays, Integer> {
}
