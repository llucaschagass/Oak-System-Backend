package br.com.oaksystem.oaksystem.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String usuario;
    private String senha;
}