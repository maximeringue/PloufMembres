package com.miage.td.bank.app.repository;

import com.miage.td.bank.app.entities.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends CrudRepository<Roles,String> {
    Roles getRoleById(String id);
}
