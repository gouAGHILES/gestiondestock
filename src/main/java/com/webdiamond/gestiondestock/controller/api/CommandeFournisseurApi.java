package com.webdiamond.gestiondestock.controller.api;

import com.webdiamond.gestiondestock.dto.CommandeClientDto;
import com.webdiamond.gestiondestock.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webdiamond.gestiondestock.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT+"/commandesfournisseurs")
public interface CommandeFournisseurApi {

    @PostMapping(value = APP_ROOT+"/commandesfournisseurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);

    @GetMapping(value = APP_ROOT+"/commandesfournisseurs/{idCommandeFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(value = APP_ROOT+"/commandesfournisseurs/{codeCommandeFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(value = APP_ROOT+"/commandesfournisseurs/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/commandesfournisseurs/{idCommandeFournisseur}")
    void deleteById(@PathVariable("idCommandeFournisseur")Integer id);
}
