package com.webdiamond.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webdiamond.gestiondestock.model.MvtStk;
import com.webdiamond.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    @JsonIgnore
    private ArticleDto article;

    private TypeMvtStk typeMvt;

    private Integer idEntreprise;

    public MvtStkDto fromEntity(MvtStk mvtStk){
        if(mvtStk == null){
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public MvtStk toEntity(MvtStkDto dto){
        if(dto == null){
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setIdEntreprise(dto.getIdEntreprise());

        return  mvtStk;
    }

}
