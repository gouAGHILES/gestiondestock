package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validator(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();

        if(articleDto == null){
            errors.add("Veuillez renseigler le code de l'article");
            errors.add("Veuillez renseigler la designation de l'article");
            errors.add("Veuillez renseigler le prix unitaire ht de l'article");
            errors.add("Veuillez renseigler le prix unitaire ttc de l'article");
            errors.add("Veuillez selectionner la categorie de l'article");
            return errors;
        }

        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("Veuillez renseigler le code de l'article");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("Veuillez renseigler la designation de l'article");
        }
        if(articleDto.getPrixUnitaireHT() == null){
            errors.add("Veuillez renseigler le prix unitaire ht de l'article");
        }
        if(articleDto.getPrixUnitaireTTC() == null){
            errors.add("Veuillez renseigler le prix unitaire ttc de l'article");
        }
        if(articleDto.getCategory() == null){
            errors.add("Veuillez selectionner la categorie de l'article");
        }

        return errors;
    }
}
