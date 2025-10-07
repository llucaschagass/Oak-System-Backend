package br.com.oaksystem.oaksystem.repository;

import br.com.oaksystem.oaksystem.dto.ProdutoMovimentacaoDTO;
import br.com.oaksystem.oaksystem.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    @Query("SELECT new br.com.oaksystem.oaksystem.dto.ProdutoMovimentacaoDTO(m.produto.nome, SUM(m.quantidadeMovimentada)) " +
           "FROM Movimentacao m " +
           "WHERE m.tipoMovimentacao = 'ENTRADA' " +
           "GROUP BY m.produto.nome " +
           "ORDER BY SUM(m.quantidadeMovimentada) DESC " +
           "LIMIT 1")
    ProdutoMovimentacaoDTO findProdutoComMaisEntradas();

    @Query("SELECT new br.com.oaksystem.oaksystem.dto.ProdutoMovimentacaoDTO(m.produto.nome, SUM(m.quantidadeMovimentada)) " +
           "FROM Movimentacao m " +
           "WHERE m.tipoMovimentacao = 'SAIDA' " +
           "GROUP BY m.produto.nome " +
           "ORDER BY SUM(m.quantidadeMovimentada) DESC " +
           "LIMIT 1")
    ProdutoMovimentacaoDTO findProdutoComMaisSaidas();
}