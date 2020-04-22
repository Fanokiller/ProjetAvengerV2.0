package com.projetjava.appli.dao;

import com.projetjava.appli.model.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportDAO extends JpaRepository<Rapport,Integer> {
}
