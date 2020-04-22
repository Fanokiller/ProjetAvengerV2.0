package com.projetjava.appli.dao;

import com.projetjava.appli.model.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmergencyDAO extends JpaRepository<Emergency, Integer> {
}
