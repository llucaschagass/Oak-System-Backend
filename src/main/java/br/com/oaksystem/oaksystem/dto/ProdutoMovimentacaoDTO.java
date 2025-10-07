package br.com.oaksystem.oaksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoMovimentacaoDTO {
    private String nomeProduto;
    private Long totalMovimentado;
}