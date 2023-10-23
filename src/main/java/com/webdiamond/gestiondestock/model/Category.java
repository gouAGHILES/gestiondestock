package com.webdiamond.gestiondestock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
public class Category extends AbstractEntity{

    private String code;

    private String designation;

    private Integer idEntreprise;

    @OneToMany( mappedBy = "category")
    List<Article> articles;

}
