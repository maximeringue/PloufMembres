package com.miage.td.bank.app.rest;

import com.miage.td.bank.app.entities.Utilisateur;
import com.miage.td.bank.app.repository.UtilisateurRepo;
import com.miage.td.bank.app.service.MetierUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    boolean getValideMembre(@PathVariable("id") String s, @RequestParam int niveau) {return membreValide.membreIsValide(s,niveau);}

    @PutMapping("{id}/cotiser")
    Utilisateur putCotisation(@PathVariable("id") String s) {return membreValide.payerCotisation(s); }
}
