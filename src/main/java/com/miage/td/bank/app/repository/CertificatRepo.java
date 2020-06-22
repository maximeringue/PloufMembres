package com.miage.td.bank.app.repository;


import com.miage.td.bank.app.entities.Certificat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepo extends CrudRepository<Certificat,String> {
    Certificat getCertificatById(String id);

}
