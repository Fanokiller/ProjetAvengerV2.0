package com.projetjava.appli.dao;

import com.projetjava.appli.model.Litige;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitigeDAO extends JpaRepository<Litige, Integer> {
}
