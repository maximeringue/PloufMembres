package com.miage.td.bank.app.service;


import com.miage.td.bank.app.repository.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetierUtilisateur {

    @Autowired
    private UtilisateurRepo clientrepo;

}

