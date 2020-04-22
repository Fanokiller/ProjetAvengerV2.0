package com.projetjava.appli.dao;

import com.projetjava.appli.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyDAO extends JpaRepository<Survey, Integer> {
}
