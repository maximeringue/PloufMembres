package com.miage.td.bank.app.entities;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Utilisateur {
    @Id
    @Size (max=16)
    public String login;

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
    public int niveau;

    @NotNull
    public int num_licence;

    @NotNull
    public String adresse_id;

    @NotNull
    public String certificat_id;

    @NotNull
    public String role_id;


}

