package com.webdiamond.gestiondestock.repository;

import com.webdiamond.gestiondestock.dto.CommandeFournisseurDto;
import com.webdiamond.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
