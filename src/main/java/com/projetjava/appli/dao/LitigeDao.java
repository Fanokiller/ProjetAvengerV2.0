package com.projetjava.appli.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitigeDao extends JpaRepository<Litige, Integer> {
}
