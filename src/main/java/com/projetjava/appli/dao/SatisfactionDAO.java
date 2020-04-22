package com.projetjava.appli.dao;

import com.projetjava.appli.model.Satisfaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisfactionDAO extends JpaRepository<Satisfaction, Integer> {
}
