package com.webdiamond.gestiondestock.controller.api;

import com.webdiamond.gestiondestock.dto.UtilisateurDto;
import com.webdiamond.gestiondestock.dto.VentesDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webdiamond.gestiondestock.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT+"/ventes")
public interface VentesApi {

    @PostMapping(value = APP_ROOT+"/ventes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VentesDto save(@RequestBody VentesDto ventesDto);

    @GetMapping(value = APP_ROOT+"/ventes/{idventes}", produces = MediaType.APPLICATION_JSON_VALUE)
    VentesDto findById(@PathVariable("idventes") Integer id);

    @GetMapping(value = APP_ROOT+"/ventes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VentesDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/ventes/{idventes}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteById(@PathVariable("idventes") Integer id);
}
