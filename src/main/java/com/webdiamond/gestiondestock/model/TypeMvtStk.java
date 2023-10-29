package com.webdiamond.gestiondestock.model;

import javax.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "typemvtstk")
public class TypeMvtStk extends AbstractEntity{

    private String type;

    private Integer idEntreprise;
}
