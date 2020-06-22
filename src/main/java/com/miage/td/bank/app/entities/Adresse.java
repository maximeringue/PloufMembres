package com.miage.td.bank.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Adresse {

    @Id
    @Size (max=5)
    public String id ;

    public int numero ;

    @Size(max=255)
    public String voirie ;

    public int codePostal ;

    @Size (max=255)
    public String ville ;

    @Size (max=255)
    public String pays ;


}
