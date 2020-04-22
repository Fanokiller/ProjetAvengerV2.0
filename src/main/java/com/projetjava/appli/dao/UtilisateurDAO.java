package com.projetjava.appli.dao;

import com.projetjava.appli.model.Utilisateur;
import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur,Integer> {
}
