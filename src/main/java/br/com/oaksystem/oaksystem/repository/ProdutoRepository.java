package br.com.oaksystem.oaksystem.repository;

import br.com.oaksystem.oaksystem.dto.ListaPrecoDTO;
import br.com.oaksystem.oaksystem.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

     @Query("SELECT new br.com.oaksystem.oaksystem.dto.ListaPrecoDTO(p.nome, p.precoUnitario, p.unidade, p.categoria.nome) FROM Produto p ORDER BY p.nome ASC")
    List<ListaPrecoDTO> findListaDePrecos();
}