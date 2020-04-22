package com.projetjava.appli.dao;

import com.projetjava.appli.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentDAO extends JpaRepository<Incident, Integer> {
}
