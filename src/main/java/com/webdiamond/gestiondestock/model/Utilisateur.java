package com.webdiamond.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity{

    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    @Embedded
    private Adresse adresse;

    private String motDePasse;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "idRoles")
    private Roles roles;
}
