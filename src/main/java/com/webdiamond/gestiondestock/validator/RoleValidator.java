package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.RolesDto;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {

    public static List<String> validator(RolesDto rolesDto){
        List<String> errors = new ArrayList<>();

        if(rolesDto == null){
            errors.add("Veuillez renseuiner le code de role");
        }
        return errors;
    }
}
