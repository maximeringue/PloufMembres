package com.miage.td.bank.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Utilisateur {
    @Id
    @Size (max=16)
    public String login;

    @NotNull
    @Size (max=16)
    public String mdp;

    @NotNull
    @Size (max=50)
    public String nom;

    @NotNull
    @Size (max=50)
    public String prenom;

    @NotNull
    @Size(max=255)
    public String mail;

    @NotNull
    public int niveau = 0;

    @NotNull
    public int numlicence = 0;


    @NotNull
    public String adresseid;

    @NotNull
    public String certificatid = "0";

    @NotNull
    public String roleid = "1";

    public boolean cotisation = false;
}

