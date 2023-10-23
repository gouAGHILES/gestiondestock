package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validator(ClientDto clientDto){

        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("Veuillez renseigner le nom de client");
            errors.add("Veuillez renseigner le prenom de client");
            errors.add("Veuillez renseigner le mail de client");
            errors.add("Veuillez renseigner le numéro de teléphone de client");
            return errors;
        }

        if(StringUtils.hasLength(clientDto.getNom())){
            errors.add("Veuillez renseigner le nom de client");
        }
        if(StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de client");
        }
        if(StringUtils.hasLength(clientDto.getEmail())){
            errors.add("Veuillez renseigner le mail de client");
        }
        if(StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("Veuillez renseigner le numero de telephone de client");
        }

        return  errors;
    }
}
