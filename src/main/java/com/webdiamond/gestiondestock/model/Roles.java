package com.webdiamond.gestiondestock.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{

    private String roleName;

    private Integer idEntreprise;

    @OneToMany(mappedBy = "roles")
    private List<Utilisateur> utilisateurs;
}
