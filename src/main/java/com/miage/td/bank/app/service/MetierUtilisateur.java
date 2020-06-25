package com.miage.td.bank.app.service;

import com.miage.td.bank.app.entities.*;
import com.miage.td.bank.app.repository.CertificatRepo;
import com.miage.td.bank.app.repository.UtilisateurRepo;
import com.miage.td.bank.app.rest.CertificatControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

@Service
public class MetierUtilisateur {

    DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    Calendar calendar = Calendar.getInstance();

    @Autowired
    private UtilisateurRepo clientrepo;
    @Autowired
    private CertificatRepo certificatRepo;

    public boolean membreIsValide (String idMembre, int niveau){
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        Certificat certificat = certificatRepo.findById(utilisateur.certificat_id).get();
        if (certificat.dateFinValid.after(calendar.getTime()))
        {
            return  false;
        }
        if (utilisateur.niveau != niveau)
        {
            return false;
        }
        // On considère qu'à la fin de chaque saison de plongée, toutes les cotisations passent à false
        return utilisateur.cotisation;
    }

    public Utilisateur payerCotisation(String idMembre){
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        utilisateur.cotisation = true;
        return this.clientrepo.save(utilisateur);
    }
}

