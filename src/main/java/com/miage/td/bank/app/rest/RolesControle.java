package com.miage.td.bank.app.rest;


import com.miage.td.bank.app.entities.Roles;
import com.miage.td.bank.app.repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RolesControle {

    @Autowired
    private RolesRepo rolesRepo;

    @PostMapping("")
    Roles postRoles(@RequestBody Roles roles){return this.rolesRepo.save(roles);
    }

    @GetMapping("{id}")
    Roles getRoles(@PathVariable("id") Roles r){
        return r;
    }
}
