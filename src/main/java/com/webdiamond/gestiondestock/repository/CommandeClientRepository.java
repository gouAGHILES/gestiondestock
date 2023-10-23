package com.webdiamond.gestiondestock.repository;

import com.webdiamond.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
}
