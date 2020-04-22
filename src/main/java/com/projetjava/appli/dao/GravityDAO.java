package com.projetjava.appli.dao;

import com.projetjava.appli.model.Gravity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GravityDAO extends JpaRepository<Gravity, Integer> {
}
