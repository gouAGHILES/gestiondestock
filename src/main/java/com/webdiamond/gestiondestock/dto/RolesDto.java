package com.webdiamond.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webdiamond.gestiondestock.model.Roles;
import com.webdiamond.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RolesDto {

    private Integer id;

    private String roleName;

    @JsonIgnore
    private List<Utilisateur> utilisateurs;

    private Integer idEntreprise;

    public RolesDto fromEntity(Roles roles){
        if(roles == null){
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .idEntreprise(roles.getIdEntreprise())
                .build();
    }

    public Roles toEntity(RolesDto dto){
        if(dto == null){
            return null;
        }

        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());

        return  roles;
    }
}
