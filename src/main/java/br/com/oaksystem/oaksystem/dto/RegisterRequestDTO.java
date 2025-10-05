package br.com.oaksystem.oaksystem.dto;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String nome;
    private String usuario;
    private String email;
    private String telefone;
    private String senha;
}