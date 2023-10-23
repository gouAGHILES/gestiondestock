package com.webdiamond.gestiondestock.repository;

import com.webdiamond.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {
}
