package com.miage.td.bank.app.rest;


import com.miage.td.bank.app.entities.Adresse;
import com.miage.td.bank.app.repository.AdresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adresses")
public class AdresseControl {

    @Autowired
    private AdresseRepo adresseRepo;

    @PostMapping("")
    Adresse postClient(@RequestBody Adresse adresse){
        return this.adresseRepo.save(adresse);
    }

    @GetMapping("{id}")
    Adresse getClient(@PathVariable("id") Adresse a){
        return a;
    }
}
