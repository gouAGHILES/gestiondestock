package com.webdiamond.gestiondestock.servicess.impl;

import com.webdiamond.gestiondestock.dto.EntrepriseDto;
import com.webdiamond.gestiondestock.exception.EntityNotFoundException;
import com.webdiamond.gestiondestock.exception.ErrorCodes;
import com.webdiamond.gestiondestock.exception.InvalidEntityException;
import com.webdiamond.gestiondestock.model.Entreprise;
import com.webdiamond.gestiondestock.repository.EntrepriseRepository;
import com.webdiamond.gestiondestock.servicess.EntrepriseService;
import com.webdiamond.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }
    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validator(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is not valid");
            throw new InvalidEntityException("l'utilisateur n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID,errors);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if( id == null){
            log.error("Utilisateur id is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(()->
                new EntityNotFoundException("l'utilisateur avec l'id = "+id+" n'est pas trouvé dans la bd", ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if( id == null){
            log.error("Utilisateur id is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
