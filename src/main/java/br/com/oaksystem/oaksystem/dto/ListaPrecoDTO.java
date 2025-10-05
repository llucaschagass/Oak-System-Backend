package br.com.oaksystem.oaksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaPrecoDTO {
    private String nomeProduto;
    private BigDecimal precoUnitario;
    private String unidade;
    private String nomeCategoria;
}