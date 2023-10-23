package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validator(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
            errors.add("Veuillez renseigner le mail de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner l'addresse de l'utilisateur");
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
            return errors;
        }

        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner le mail de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        if(utilisateurDto.getDateDeNaissance() == null){
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
        }
        if(utilisateurDto.getAdresseDto() == null){
            errors.add("Veuillez renseigner l'addresse de l'utilisateur");
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getAdresse1())){
                errors.add("Le champ 'Adresse 1' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getCodePostale())){
                errors.add("Le champ 'code postale' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getPays())){
                errors.add("Le champ 'pays' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getVille())){
                errors.add("Le champ 'ville' est obligatoire");
            }
        }
        return errors;
    }
}
