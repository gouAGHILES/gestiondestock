package com.webdiamond.gestiondestock.servicess;

import com.webdiamond.gestiondestock.dto.CommandeClientDto;

import java.util.List;
import java.util.Optional;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto commandeClientDto);

    CommandeClientDto findById(Integer id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void deleteById(Integer id);
}
