package com.miage.td.bank.app.service;

import com.miage.td.bank.app.entities.*;
import com.miage.td.bank.app.repository.CertificatRepo;
import com.miage.td.bank.app.repository.UtilisateurRepo;
import com.miage.td.bank.app.rest.CertificatControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Service
public class MetierUtilisateur {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();


    @Autowired
    private UtilisateurRepo clientrepo;
    @Autowired
    private CertificatRepo certificatRepo;

    public Utilisateur membreIsValide (String idMembre, int niveau){
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        Certificat certificat = certificatRepo.findById(utilisateur.certificatid).get();

        dateFormat.format(date);

        if (certificat.dateFinValid.before(date))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La date du certificat n'est pas valide");
        }
        if (utilisateur.niveau != niveau)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Le niveau n'est pas valide");
        }
        if (!utilisateur.cotisation)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La cotisation n'est pas valide");
        }

        // On considère qu'à la fin de chaque saison de plongée, toutes les cotisations passent à false
        return utilisateur;
    }

    public Utilisateur payerCotisation(String idMembre){
        // On considère qu'on réinitialise toutes les cotisations à chaque début d'année civile
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        utilisateur.cotisation = true;
        return this.clientrepo.save(utilisateur);
    }

    public Utilisateur certifier(String idMembre, String certificat_id){
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        utilisateur.certificatid = certificat_id;
        return this.clientrepo.save(utilisateur);
    }
    public Utilisateur donnerLicence(String idMembre, int numLicence){
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        utilisateur.numlicence = numLicence;
        return this.clientrepo.save(utilisateur);
    }
    public Utilisateur donnerNiveau(String idMembre, int niveau){
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        utilisateur.niveau = niveau;
        return this.clientrepo.save(utilisateur);
    }

    public Utilisateur enseigner(String idMembre){
        Utilisateur utilisateur = clientrepo.findById(idMembre).get();
        utilisateur.roleid = "2";
        return utilisateur;
    }
}

