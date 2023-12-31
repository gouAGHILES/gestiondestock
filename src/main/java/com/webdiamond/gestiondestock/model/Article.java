package com.webdiamond.gestiondestock.model;
import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class Article  extends AbstractEntity{

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHT;

    private Integer idEntreprise;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTTC;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;
}
