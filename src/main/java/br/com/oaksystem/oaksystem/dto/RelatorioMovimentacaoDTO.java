package br.com.oaksystem.oaksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioMovimentacaoDTO {
    private ProdutoMovimentacaoDTO produtoComMaisSaidas;
    private ProdutoMovimentacaoDTO produtoComMaisEntradas;
}