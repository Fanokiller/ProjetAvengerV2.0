package com.projetjava.appli.dao;

import com.projetjava.appli.model.Crise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriseDAO extends JpaRepository<Crise,Integer> {
}
