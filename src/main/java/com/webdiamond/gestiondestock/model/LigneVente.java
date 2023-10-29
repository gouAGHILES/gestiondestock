package com.webdiamond.gestiondestock.model;

import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity{

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idVentes")
    private Ventes ventes;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;
}
