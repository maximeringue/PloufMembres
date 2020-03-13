package com.miage.td.bank.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compte {
    @Id
    public String id;


    public double solde;

    @ManyToOne
    public String idclient;





}
