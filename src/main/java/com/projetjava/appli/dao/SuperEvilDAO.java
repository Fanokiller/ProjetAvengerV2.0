package com.projetjava.appli.dao;

import com.projetjava.appli.model.SuperEvil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperEvilDAO extends JpaRepository<SuperEvil,Integer> {
}
