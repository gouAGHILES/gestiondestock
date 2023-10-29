package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.CommandeFournisseurDto;
import com.webdiamond.gestiondestock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {

    public static List<String> validate(VentesDto ventesDto){
        List<String> errors = new ArrayList<>();
        if(ventesDto == null){
            errors.add("Vuiller renseigner le code de la vente");
            return errors;
        }

        if(!StringUtils.hasLength(ventesDto.getCode())){
            errors.add("Vuiller renseigner le code de la vente");
        }

        return errors;
    }
}
