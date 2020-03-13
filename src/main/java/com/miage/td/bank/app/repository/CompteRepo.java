package com.miage.td.bank.app.repository;

import com.miage.td.bank.app.entities.Compte;
import org.springframework.data.repository.CrudRepository;

public interface CompteRepo extends CrudRepository<Compte,String> {

}
