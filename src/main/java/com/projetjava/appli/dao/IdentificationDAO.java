package com.projetjava.appli.dao;

import com.projetjava.appli.model.Identification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationDAO extends JpaRepository<Identification, Integer> {
}
