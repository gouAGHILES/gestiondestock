package com.webdiamond.gestiondestock.controller;

import com.webdiamond.gestiondestock.controller.api.ClientApi;
import com.webdiamond.gestiondestock.dto.ClientDto;
import com.webdiamond.gestiondestock.servicess.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.sava(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        clientService.deleteById(id);
    }
}
