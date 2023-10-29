package com.webdiamond.gestiondestock.controller;

import com.webdiamond.gestiondestock.controller.api.ClientApi;
import com.webdiamond.gestiondestock.controller.api.FournisseurApi;
import com.webdiamond.gestiondestock.dto.ClientDto;
import com.webdiamond.gestiondestock.dto.FournisseurDto;
import com.webdiamond.gestiondestock.servicess.ClientService;
import com.webdiamond.gestiondestock.servicess.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService){
        this.fournisseurService = fournisseurService;
    }
    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.sava(fournisseurDto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        fournisseurService.deleteById(id);
    }
}
