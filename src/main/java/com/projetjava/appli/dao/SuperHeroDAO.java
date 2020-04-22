package com.projetjava.appli.dao;

import com.projetjava.appli.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroDAO extends JpaRepository<SuperHero, Integer> {
}
