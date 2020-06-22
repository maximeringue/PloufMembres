package com.miage.td.bank.app.repository;

import com.miage.td.bank.app.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur,String> {
    Utilisateur getClientById(String id);
}
