package com.webdiamond.gestiondestock.servicess;

import com.webdiamond.gestiondestock.dto.VentesDto;

import java.util.List;

public interface VenteServices {

    VentesDto save(VentesDto ventesDto);

    VentesDto findById(Integer id);

    VentesDto findByCode(String code);

    List<VentesDto> findAll();

    void deleteById(Integer id);

}
