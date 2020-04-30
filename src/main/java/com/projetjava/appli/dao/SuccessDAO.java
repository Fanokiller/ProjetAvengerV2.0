package com.projetjava.appli.dao;

import com.projetjava.appli.model.Success;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessDAO extends JpaRepository<Success, Integer> {
}
