package com.projetjava.appli.dao;

import com.projetjava.appli.model.Missions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionsDAO extends JpaRepository<Missions, Integer> {
}
