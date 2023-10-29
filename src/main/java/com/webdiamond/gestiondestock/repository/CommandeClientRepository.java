package com.webdiamond.gestiondestock.repository;

import com.webdiamond.gestiondestock.model.CommandeClient;
import com.webdiamond.gestiondestock.servicess.CommandeClientService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {

    Optional<CommandeClient> findCommandeClientByCode(String code);
}
