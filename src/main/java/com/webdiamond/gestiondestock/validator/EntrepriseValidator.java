package com.webdiamond.gestiondestock.validator;

import com.webdiamond.gestiondestock.dto.EntrepriseDto;
import com.webdiamond.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validator(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null){
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez renseigner la description de l'entreprise");
            errors.add("Veuillez renseigner le mail de l'entreprise");
            errors.add("Veuillez renseigner le numéro de téléphone de l'entreprise");
            errors.add("Veuillez renseigner l'addresse de l'entreprise");
            errors.add("Veuillez renseigner site web de l'entreprise");
            return errors;
        }

        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getDescription())){
            errors.add("Veuillez renseigner la description de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("Veuillez renseigner le mail de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Veuillez renseigner le numéro de téléphone de l'utilisateur");
        }
        if(!StringUtils.hasLength(entrepriseDto.getSiteWeb())){
            errors.add("Veuillez renseigner site web de l'entreprise");
        }
        if(entrepriseDto.getAdresseDto() == null){
            errors.add("Veuillez renseigner l'addresse de l'utilisateur");
            if(!StringUtils.hasLength(entrepriseDto.getAdresseDto().getAdresse1())){
                errors.add("Le champ 'Adresse 1' est obligatoire");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresseDto().getCodePostale())){
                errors.add("Le champ 'code postale' est obligatoire");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresseDto().getPays())){
                errors.add("Le champ 'pays' est obligatoire");
            }
            if(!StringUtils.hasLength(entrepriseDto .getAdresseDto().getVille())){
                errors.add("Le champ 'ville' est obligatoire");
            }
        }
        return errors;
    }
}
