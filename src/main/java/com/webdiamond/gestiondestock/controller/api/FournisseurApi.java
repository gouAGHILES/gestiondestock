package com.webdiamond.gestiondestock.controller.api;

import com.webdiamond.gestiondestock.dto.ClientDto;
import com.webdiamond.gestiondestock.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webdiamond.gestiondestock.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT+"/fournisseurs")
public interface FournisseurApi {

    @PostMapping(value = APP_ROOT+"/fournisseurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);

    @GetMapping(value = APP_ROOT+"/fournisseurs/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(value = APP_ROOT+"/fournisseurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/fournisseurs/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteById(@PathVariable("idFournisseur") Integer id);
}
