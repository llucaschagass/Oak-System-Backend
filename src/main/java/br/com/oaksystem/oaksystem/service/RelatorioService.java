package br.com.oaksystem.oaksystem.service;

import br.com.oaksystem.oaksystem.dto.ListaPrecoDTO;
import br.com.oaksystem.oaksystem.dto.BalancoGeralDTO;
import br.com.oaksystem.oaksystem.dto.BalancoItemDTO;
import br.com.oaksystem.oaksystem.dto.ProdutoAbaixoMinimoDTO;

import br.com.oaksystem.oaksystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;

@Service
public class RelatorioService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ListaPrecoDTO> gerarListaDePrecos() {
        return produtoRepository.findListaDePrecos();
    }

    public BalancoGeralDTO gerarBalancoFisicoFinanceiro() {
        List<BalancoItemDTO> itens = produtoRepository.findItensBalanco();

        BigDecimal valorTotalEstoque = itens.stream()
                .map(BalancoItemDTO::getValorTotalProduto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new BalancoGeralDTO(valorTotalEstoque, itens);
    }

    public List<ProdutoAbaixoMinimoDTO> gerarRelatorioProdutosAbaixoMinimo() {
        return produtoRepository.findProdutosAbaixoDoMinimo();
    }
}