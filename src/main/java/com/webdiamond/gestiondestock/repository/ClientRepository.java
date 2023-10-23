package com.webdiamond.gestiondestock.repository;

import com.webdiamond.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
