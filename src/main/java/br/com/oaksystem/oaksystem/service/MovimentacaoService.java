package br.com.oaksystem.oaksystem.service;

import br.com.oaksystem.oaksystem.model.Movimentacao;
import br.com.oaksystem.oaksystem.model.Produto;
import br.com.oaksystem.oaksystem.model.TipoMovimentacao;
import br.com.oaksystem.oaksystem.repository.MovimentacaoRepository;
import br.com.oaksystem.oaksystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Movimentacao> listarTodas() {
        return movimentacaoRepository.findAll();
    }

    @Transactional
    public Movimentacao registrarMovimentacao(Movimentacao movimentacao) {
        // Busca o produto do banco de dados para garantir que ele existe.
        Produto produto = produtoRepository.findById(movimentacao.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        int quantidadeMovimentada = movimentacao.getQuantidadeMovimentada();
        int estoqueAtual = produto.getQuantidadeEmEstoque();

        // Aplica a regra de negócio baseada no tipo de movimentação.
        if (movimentacao.getTipoMovimentacao() == TipoMovimentacao.SAIDA) {
            if (estoqueAtual < quantidadeMovimentada) {
                throw new RuntimeException("Estoque insuficiente para a saída!");
            }
            produto.setQuantidadeEmEstoque(estoqueAtual - quantidadeMovimentada);
            
            // Avisa se o estoque ficou abaixo do mínimo.
            if (produto.getQuantidadeEmEstoque() < produto.getQuantidadeMinima()) {
                System.out.println("ALERTA: Estoque do produto '" + produto.getNome() + "' está abaixo do mínimo!");
            }
        } else if (movimentacao.getTipoMovimentacao() == TipoMovimentacao.ENTRADA) {
            produto.setQuantidadeEmEstoque(estoqueAtual + quantidadeMovimentada);

            // Avisa se o estoque ficou acima do máximo.
            if (produto.getQuantidadeEmEstoque() > produto.getQuantidadeMaxima()) {
                System.out.println("AVISO: Estoque do produto '" + produto.getNome() + "' ultrapassou o máximo recomendado!");
            }
        }

        produtoRepository.save(produto);

        return movimentacaoRepository.save(movimentacao);
    }
}