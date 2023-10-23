package com.webdiamond.gestiondestock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity{

    private String code;

    private Instant dateVente;

    private String commentaire;

    private Integer idEntreprise;

    @OneToMany(mappedBy = "ventes")
    private List<LigneVente> ligneVentes;
}
