package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validator(FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();

        if(fournisseurDto == null){
            errors.add("Veuillez renseigner le nom de fournisseur");
            errors.add("Veuillez renseigner le prenom de fournisseur");
            errors.add("Veuillez renseigner le mail de fournisseur");
            errors.add("Veuillez renseigner le numéro de teléphone de fournisseur");
            return errors;
        }

        if(StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Veuillez renseigner le nom de fournisseur");
        }
        if(StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de fournisseur");
        }
        if(StringUtils.hasLength(fournisseurDto.getEmail())){
            errors.add("Veuillez renseigner le mail de fournisseur");
        }
        if(StringUtils.hasLength(fournisseurDto.getNumTel())){
            errors.add("Veuillez renseigner le numero de telephone de fournisseur");
        }

        return  errors;


    }
}
