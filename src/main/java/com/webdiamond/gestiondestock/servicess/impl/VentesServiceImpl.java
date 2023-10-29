package com.webdiamond.gestiondestock.servicess.impl;
import com.webdiamond.gestiondestock.dto.LigneVenteDto;
import com.webdiamond.gestiondestock.dto.VentesDto;
import com.webdiamond.gestiondestock.exception.EntityNotFoundException;
import com.webdiamond.gestiondestock.exception.ErrorCodes;
import com.webdiamond.gestiondestock.exception.InvalidEntityException;
import com.webdiamond.gestiondestock.model.Article;
import com.webdiamond.gestiondestock.model.LigneVente;
import com.webdiamond.gestiondestock.model.Ventes;
import com.webdiamond.gestiondestock.repository.ArticleRepository;
import com.webdiamond.gestiondestock.repository.LigneVenteRepository;
import com.webdiamond.gestiondestock.repository.VentesRepository;
import com.webdiamond.gestiondestock.servicess.VenteServices;
import com.webdiamond.gestiondestock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServiceImpl implements VenteServices {

    private VentesRepository ventesRepository;

    private ArticleRepository articleRepository;

    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VentesServiceImpl(VentesRepository ventesRepository, ArticleRepository articleRepository, LigneVenteRepository ligneVenteRepository){
        this.ligneVenteRepository = ligneVenteRepository;
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
    }


    @Override
    public VentesDto save(VentesDto ventesDto) {
        List<String> errors = VentesValidator.validate(ventesDto);
        if(!errors.isEmpty()){
            log.error("Ventes is not valid");
            throw new InvalidEntityException("Ventes n'est pas valide", ErrorCodes.VENTE_NOT_VALID,errors);
        }
        List<String> articleErrors = new ArrayList<>();

        if(ventesDto.getLigneVentes() !=null){
            ventesDto.getLigneVentes().forEach(lngVentes -> {
                        if (lngVentes.getArticle() != null) {
                            Optional<Article> article = articleRepository.findById(lngVentes.getArticle().getId());
                            if (article.isEmpty()){
                                articleErrors.add("l'article avec l'ID = "+lngVentes.getArticle().getId()+"n'est pas présent dans la BD");
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

        Ventes vente = ventesRepository.save(VentesDto.toEntity(ventesDto));

        if(ventesDto.getLigneVentes() != null){
            ventesDto.getLigneVentes().forEach(lngVentes ->{
                LigneVente ligneVente = LigneVenteDto.toEntity(lngVentes);
                ligneVente.setVentes(vente);
                ligneVenteRepository.save(ligneVente);
                    }

            );
        }
            return VentesDto.fromEntity(vente);
    }

    @Override
    public VentesDto findById(Integer id) {
        if(id == null){
            log.error("Vente ID is NULL");
            return null;
        }
        return ventesRepository.findById(id).map(VentesDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("La vente avec ID = "+id+ " n'existe pas dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public VentesDto findByCode(String code) {
        if(code == null){
            log.error("Vente Code is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code).map(VentesDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("La vente avec le Code = "+code+ " n'existe pas dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream().map(VentesDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if(id == null){
            log.error("Vente ID is NULL");
            return;
        }
        ventesRepository.deleteById(id);
    }
}
