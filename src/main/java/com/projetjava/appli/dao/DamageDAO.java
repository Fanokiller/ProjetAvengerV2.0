package com.projetjava.appli.dao;

import com.projetjava.appli.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageDAO extends JpaRepository<Damage, Integer> {
}
