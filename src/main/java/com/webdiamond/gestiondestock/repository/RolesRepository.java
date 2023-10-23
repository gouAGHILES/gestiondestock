package com.webdiamond.gestiondestock.repository;

import com.webdiamond.gestiondestock.model.Roles;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
