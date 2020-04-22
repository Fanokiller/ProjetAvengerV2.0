package com.projetjava.appli.dao;

import com.projetjava.appli.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InformationDAO extends JpaRepository<Information, Integer> {
}
