package com.webdiamond.gestiondestock.controller.api;

import com.webdiamond.gestiondestock.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webdiamond.gestiondestock.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT+"/entreprises")
public interface EntrepriseApi {

    @PostMapping(value = APP_ROOT+"/entreprises/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);

    @GetMapping(value = APP_ROOT+"/entreprises/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(value = APP_ROOT+"/entreprises/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/entreprises/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteById(@PathVariable("idEntreprise") Integer id);
}
