package com.webdiamond.gestiondestock.dto;

import com.webdiamond.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHT;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTTC;

    private String photo;

    private CategoryDto category;

    private Integer idEntreprise;

    public static ArticleDto fromEntity(Article article){
        if(article==null){
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .photo(article.getPhoto())
                .designation(article.getDesignation())
                .prixUnitaireHT(article.getPrixUnitaireHT())
                .prixUnitaireTTC(article.getPrixUnitaireTTC())
                .tauxTva(article.getTauxTva())
                .idEntreprise(article.getIdEntreprise())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto dto){
        if(dto == null){
            return null;
        }

        Article article = new Article();

        article.setId(dto.getId());
        article.setCodeArticle(dto.getCodeArticle());
        article.setPhoto(dto.getPhoto());
        article.setDesignation(article.getDesignation());
        article.setPrixUnitaireHT(dto.getPrixUnitaireHT());
        article.setPrixUnitaireTTC(dto.getPrixUnitaireTTC());
        article.setTauxTva(dto.getTauxTva());
        article.setIdEntreprise(dto.getIdEntreprise());
        article.setCategory(CategoryDto.toEntity(dto.getCategory()));
        return article;

    }

}
