package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.CommandeClientDto;
import com.webdiamond.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {



    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors = new ArrayList<>();
        if(commandeFournisseurDto == null){
            errors.add("Vuiller renseigner le code de la commande fournisseur");
            errors.add("Veuillez renseuigner le client de la commande fournisseur");
            return errors;
        }

        if(!StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add("Vuiller renseigner le code de la commande fournisseur");
        }
        if(commandeFournisseurDto.getFournisseur() == null){
            errors.add("Veuillez renseuigner le fournisseur de la commande client");
        }else if(commandeFournisseurDto.getFournisseur().getId() == null) {
            errors.add("l'id de fournisseur est null");
        }

        return errors;
    }
}
