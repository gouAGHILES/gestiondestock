package com.webdiamond.gestiondestock.servicess.impl;

import com.webdiamond.gestiondestock.dto.CommandeClientDto;
import com.webdiamond.gestiondestock.dto.LigneCommandeClientDto;
import com.webdiamond.gestiondestock.exception.EntityNotFoundException;
import com.webdiamond.gestiondestock.exception.ErrorCodes;
import com.webdiamond.gestiondestock.exception.InvalidEntityException;
import com.webdiamond.gestiondestock.model.Article;
import com.webdiamond.gestiondestock.model.Client;
import com.webdiamond.gestiondestock.model.CommandeClient;
import com.webdiamond.gestiondestock.model.LigneCommandeClient;
import com.webdiamond.gestiondestock.repository.ArticleRepository;
import com.webdiamond.gestiondestock.repository.ClientRepository;
import com.webdiamond.gestiondestock.repository.CommandeClientRepository;
import com.webdiamond.gestiondestock.repository.LigneCommandeClientRepository;
import com.webdiamond.gestiondestock.servicess.CommandeClientService;
import com.webdiamond.gestiondestock.validator.CommandeClientValidator;
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
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository,ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository){
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }
    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Commande client is not valid");
            throw new InvalidEntityException("Commande client non valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
        }

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if(client.isPresent()){
            log.warn("Client with ID {} was not found in the DB", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'id = "+dto.getClient().getId()+" n'est trouvé dans la bd",ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if(dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                if(ligCmdClt.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("l'article avec l'ID = "+ligCmdClt.getArticle().getId()+"n'est pas présent dans la BD");
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

        CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if(dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeClient(savedCmdClt);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null){
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande client n'a été trouvé avec l'ID = "+id+" dans la BDD", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)
                );
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Commande client Code is NULL");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande client n'a été trouvé avec le code = "+code+" dans la BDD", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)
                );
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {

        if(id == null){
            log.error("Commande client ID is NULL");
            return;
        }

        commandeClientRepository.deleteById(id);
    }
}
