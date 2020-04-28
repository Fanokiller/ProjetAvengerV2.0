package com.projetjava.appli.dao;

import com.projetjava.appli.model.Nature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureDAO extends JpaRepository<Nature,Integer>{


}
