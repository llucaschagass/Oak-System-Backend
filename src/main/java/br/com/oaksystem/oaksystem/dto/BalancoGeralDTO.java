package br.com.oaksystem.oaksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalancoGeralDTO {
    private BigDecimal valorTotalEstoque;
    private List<BalancoItemDTO> itens;
}