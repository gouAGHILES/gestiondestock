package com.webdiamond.gestiondestock.controller.api;

import com.webdiamond.gestiondestock.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webdiamond.gestiondestock.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT+"/commandesclients")
public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT+"/commandesclients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto save(@RequestBody CommandeClientDto commandeClientDto);

    @GetMapping(value = APP_ROOT+"/commandesclients/{idCommandeClient}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findById(@PathVariable("idCommandeClient") Integer id);

    @GetMapping(value = APP_ROOT+"/commandesclients/{codeCommandeClient}",produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(value = APP_ROOT+"/commandesclients/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeClientDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/commandesclients/{idCommandeClient}")
    void deleteById(@PathVariable("idCommandeClient")Integer id);
}
