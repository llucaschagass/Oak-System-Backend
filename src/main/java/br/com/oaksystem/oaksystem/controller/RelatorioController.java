package br.com.oaksystem.oaksystem.controller;

import br.com.oaksystem.oaksystem.dto.ListaPrecoDTO;
import br.com.oaksystem.oaksystem.dto.BalancoGeralDTO;
import br.com.oaksystem.oaksystem.dto.ProdutoAbaixoMinimoDTO;

import br.com.oaksystem.oaksystem.service.RelatorioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
@Tag(name = "Relatórios", description = "Endpoints para geração de relatórios do sistema")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/lista-de-precos")
    public List<ListaPrecoDTO> getListaDePrecos() {
        return relatorioService.gerarListaDePrecos();
    }

    @GetMapping("/balanco-financeiro")
    public BalancoGeralDTO getBalancoFinanceiro() {
        return relatorioService.gerarBalancoFisicoFinanceiro();
    }

    @GetMapping("/produtos-abaixo-minimo")
    public List<ProdutoAbaixoMinimoDTO> getProdutosAbaixoMinimo() {
        return relatorioService.gerarRelatorioProdutosAbaixoMinimo();
    }
}