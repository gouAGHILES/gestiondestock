package com.webdiamond.gestiondestock.controller.api;

import com.webdiamond.gestiondestock.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.webdiamond.gestiondestock.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT+"/utilisateurs")
public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT+"/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value = APP_ROOT+"/utilisateurs/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(value = APP_ROOT+"/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/utilisateurs/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteById(@PathVariable("idUtilisateur") Integer id);
}
