package br.com.oaksystem.oaksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalancoItemDTO {
    private String nomeProduto;
    private int quantidadeEmEstoque;
    private BigDecimal valorTotalProduto;
}