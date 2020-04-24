package com.projetjava.appli.dao;

import com.projetjava.appli.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionDAO extends JpaRepository<Mission, Integer> {
}
