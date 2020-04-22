package com.projetjava.appli.dao;

import com.projetjava.appli.model.Civil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivilDAO extends JpaRepository<Civil,Integer> {
}
