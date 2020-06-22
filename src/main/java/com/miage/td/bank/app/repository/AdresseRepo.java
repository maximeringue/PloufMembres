package com.miage.td.bank.app.repository;

import com.miage.td.bank.app.entities.Adresse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepo extends CrudRepository<Adresse,String> {
    Adresse getAdresseById(String id);
}
