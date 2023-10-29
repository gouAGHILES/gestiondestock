package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {



    public static List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();
        if(commandeClientDto == null){
            errors.add("Vuiller renseigner le code de la commande client");
            errors.add("Veuillez renseuigner le client de la commande client");
            return errors;
        }

        if(!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("Vuiller renseigner le code de la commande client");
        }
        if(commandeClientDto.getClient() == null){
            errors.add("Veuillez renseuigner le client de la commande client");
        }else if(commandeClientDto.getClient().getId() == null) {
            errors.add("l'id de client est null");
        }

        return errors;
    }
}
