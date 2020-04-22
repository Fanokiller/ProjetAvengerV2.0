package com.projetjava.appli.dao;

import com.projetjava.appli.model.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityDAO extends JpaRepository<Ability, Integer> {
}
