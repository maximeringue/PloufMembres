package com.miage.td.bank.app.rest;

import com.miage.td.bank.app.entities.Utilisateur;
import com.miage.td.bank.app.repository.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class UtilisateurControl {

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @PostMapping("")
    Utilisateur postClient(@RequestBody Utilisateur utilisateur){
        return this.utilisateurRepo.save(utilisateur);
    }

    @GetMapping("{id}")
    Utilisateur getClient(@PathVariable("id") Utilisateur c){
        return c;
    }
}
