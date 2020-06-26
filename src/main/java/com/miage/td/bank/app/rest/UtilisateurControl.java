package com.miage.td.bank.app.rest;

import com.miage.td.bank.app.entities.Adresse;
import com.miage.td.bank.app.entities.Certificat;
import com.miage.td.bank.app.entities.Utilisateur;
import com.miage.td.bank.app.repository.UtilisateurRepo;
import com.miage.td.bank.app.service.MetierUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/clients")
public class UtilisateurControl {

    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private MetierUtilisateur membreValide;

    @PostMapping("")
    Utilisateur postClient(@RequestBody Utilisateur utilisateur){
        return this.utilisateurRepo.save(utilisateur);
    }

    @GetMapping("{id}")
    Utilisateur getClient(@PathVariable("id") Utilisateur c){
        return c;
    }

    @GetMapping("{id}/verif")
    Utilisateur getValideMembre(@PathVariable("id") String s, @RequestParam int niveau) {return membreValide.membreIsValide(s,niveau);}

    @PutMapping("{id}/cotiser")
    Utilisateur putCotisation(@PathVariable("id") String s) {return membreValide.payerCotisation(s); }

    @PutMapping("{id}/certificat")
    Utilisateur putCertificat(@PathVariable("id") String s, @RequestBody Certificat certificat)
    {return membreValide.certifier(s,certificat.id);}

    @PutMapping("{id}/licence")
    Utilisateur putLicence(@PathVariable("id") String s, @RequestParam int numlicence)
    {return membreValide.donnerLicence(s,numlicence);}

    @PutMapping("{id}/niveau")
    Utilisateur putNiveau(@PathVariable("id") String s, @RequestParam int niveau)
    {return membreValide.donnerNiveau(s,niveau);}

}
