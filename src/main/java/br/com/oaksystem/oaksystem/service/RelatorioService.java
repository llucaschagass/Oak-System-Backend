package br.com.oaksystem.oaksystem.service;

import br.com.oaksystem.oaksystem.dto.ListaPrecoDTO;
import br.com.oaksystem.oaksystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ListaPrecoDTO> gerarListaDePrecos() {
        return produtoRepository.findListaDePrecos();
    }
}