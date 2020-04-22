package com.projetjava.appli.dao;

import com.projetjava.appli.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationDAO extends JpaRepository<Organisation, Integer> {
}
