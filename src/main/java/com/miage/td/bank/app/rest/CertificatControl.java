package com.miage.td.bank.app.rest;


import com.miage.td.bank.app.entities.Certificat;
import com.miage.td.bank.app.repository.CertificatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificat")
public class CertificatControl {

    @Autowired
    private CertificatRepo certificatRepo;

    @PostMapping("")
    Certificat postClient(@RequestBody Certificat certificat){
        return this.certificatRepo.save(certificat);
    }

    @GetMapping("{id}")
    Certificat getClient(@PathVariable("id") Certificat c){
        return c;
    }
}
