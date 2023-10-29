package com.webdiamond.gestiondestock.servicess.impl;

import com.webdiamond.gestiondestock.dto.ClientDto;
import com.webdiamond.gestiondestock.dto.FournisseurDto;
import com.webdiamond.gestiondestock.exception.EntityNotFoundException;
import com.webdiamond.gestiondestock.exception.ErrorCodes;
import com.webdiamond.gestiondestock.exception.InvalidEntityException;
import com.webdiamond.gestiondestock.model.Client;
import com.webdiamond.gestiondestock.model.Fournisseur;
import com.webdiamond.gestiondestock.repository.ClientRepository;
import com.webdiamond.gestiondestock.repository.FournisseurRepository;
import com.webdiamond.gestiondestock.servicess.ClientService;
import com.webdiamond.gestiondestock.servicess.FournisseurService;
import com.webdiamond.gestiondestock.validator.ClientValidator;
import com.webdiamond.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public FournisseurDto sava(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validator(fournisseurDto);
        if(!errors.isEmpty()){
            log.error("Fournisseur is not valid");
            throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID,errors);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id == null){
            log.error("Fournisseur id is null");
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException("le fournisseur avec l'id = "+id+" n'est pas trouvé dans la bd", ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if(id == null){
            log.error("Fournisseur id is null");
            return;
        }
        fournisseurRepository.deleteById(id);
    }
}
