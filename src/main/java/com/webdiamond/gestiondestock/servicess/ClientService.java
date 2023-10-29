package com.webdiamond.gestiondestock.servicess;

import com.webdiamond.gestiondestock.dto.ArticleDto;
import com.webdiamond.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto sava(ClientDto clientDto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void deleteById(Integer id);

}