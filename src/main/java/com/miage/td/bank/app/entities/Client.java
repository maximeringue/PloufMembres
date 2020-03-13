package com.miage.td.bank.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Client {
    @Id
    public String id;

    @NotNull
    public String nom;
    @NotNull
    public String prenom;


    @OneToMany
    public List<Compte> comptes;
}

