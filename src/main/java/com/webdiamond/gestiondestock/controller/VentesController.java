package com.webdiamond.gestiondestock.controller;

import com.webdiamond.gestiondestock.controller.api.UtilisateurApi;
import com.webdiamond.gestiondestock.controller.api.VentesApi;
import com.webdiamond.gestiondestock.dto.UtilisateurDto;
import com.webdiamond.gestiondestock.dto.VentesDto;
import com.webdiamond.gestiondestock.servicess.UtilisateurService;
import com.webdiamond.gestiondestock.servicess.VenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentesController implements VentesApi {

    private VenteServices venteServices;

    @Autowired
    public VentesController(VenteServices venteServices){
        this.venteServices=venteServices;
    }
    @Override
    public VentesDto save(VentesDto ventesDto) {
        return venteServices.save(ventesDto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return venteServices.findById(id);
    }

    @Override
    public List<VentesDto> findAll() {
        return venteServices.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        venteServices.deleteById(id);
    }
}
