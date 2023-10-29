package com.webdiamond.gestiondestock.servicess.impl;

import com.webdiamond.gestiondestock.dto.CommandeClientDto;
import com.webdiamond.gestiondestock.dto.CommandeFournisseurDto;
import com.webdiamond.gestiondestock.dto.LigneCommandeClientDto;
import com.webdiamond.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.webdiamond.gestiondestock.exception.EntityNotFoundException;
import com.webdiamond.gestiondestock.exception.ErrorCodes;
import com.webdiamond.gestiondestock.exception.InvalidEntityException;
import com.webdiamond.gestiondestock.model.*;
import com.webdiamond.gestiondestock.repository.*;
import com.webdiamond.gestiondestock.servicess.CommandeClientService;
import com.webdiamond.gestiondestock.servicess.CommandeFournisseurService;
import com.webdiamond.gestiondestock.validator.CommandeClientValidator;
import com.webdiamond.gestiondestock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, FournisseurRepository fournisseurRepository, ArticleRepository articleRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository){
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
    }
    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Commande Fournisseur is not valid");
            throw new InvalidEntityException("Commande Fournisseur non valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if(fournisseur.isPresent()){
            log.warn("Fournisseur with ID {} was not found in the DB", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'id = "+dto.getFournisseur().getId()+" n'est trouvé dans la bd",ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if(dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdfr -> {
                if(ligCmdfr.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ligCmdfr.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("l'article avec l'ID = "+ligCmdfr.getArticle().getId()+"n'est pas présent dans la BD");
                    }
                }else{
                    articleErrors.add("Imposible d'enregistrer une commande avec un article null");
                }
            }
            );
        }

        if(!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }

        CommandeFournisseur savedCmdfr = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        if(dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdfr -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdfr);
                ligneCommandeFournisseur.setCommandeFournisseur(savedCmdfr);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }

        return CommandeFournisseurDto.fromEntity(savedCmdfr);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id == null){
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande fournisseur n'a été trouvé avec l'ID = "+id+" dans la BDD", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
                );
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Commande fournisseur Code is NULL");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande fournisseur n'a été trouvé avec le code = "+code+" dans la BDD", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
                );
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {

        if(id == null){
            log.error("Commande fournisseur ID is NULL");
            return;
        }

        commandeFournisseurRepository.deleteById(id);
    }
}
