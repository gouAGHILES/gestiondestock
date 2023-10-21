package com.webdiamond.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webdiamond.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    @JsonIgnore
    private AdresseDto adresseDto;

    private String photo;

    private String email;

    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .numTel(client.getNumTel())
                .email(client.getEmail())
                .build();
    }

    public Client toEntity(ClientDto dto){
        if(dto == null){
            return null;
        }

        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setPhoto(dto.getPhoto());
        client.setNumTel(dto.getNumTel());
        client.setEmail(dto.getEmail());

        return client;
    }
}
