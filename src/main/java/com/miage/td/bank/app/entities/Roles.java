package com.miage.td.bank.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Roles {

    @Id
    @Size (max=5)
    public String id;

    @Size(max=255)
    public String name;

}
