package com.webdiamond.gestiondestock.servicess;

import com.webdiamond.gestiondestock.dto.ClientDto;
import com.webdiamond.gestiondestock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto sava(FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    void deleteById(Integer id);

}