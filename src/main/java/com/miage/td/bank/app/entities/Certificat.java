package com.miage.td.bank.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Certificat {

    @Id
    @Size (max=5)
    public String id;

    public int numeroCertificat;

    public Date dateDebutValid;

    public Date dateFinValid;

    @Size(max=255)
    public String pays;



}
