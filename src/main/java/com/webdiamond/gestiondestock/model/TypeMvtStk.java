package com.webdiamond.gestiondestock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "typemvtstk")
public class TypeMvtStk {

    private String type;

    private Integer idEntreprise;
}
