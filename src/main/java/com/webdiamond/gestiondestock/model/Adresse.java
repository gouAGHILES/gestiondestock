package com.webdiamond.gestiondestock.model;


import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse{

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostale;

    private String pays;
}
