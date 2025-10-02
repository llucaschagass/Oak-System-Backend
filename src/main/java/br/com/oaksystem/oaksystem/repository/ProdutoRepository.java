package br.com.oaksystem.oaksystem.repository;

import br.com.oaksystem.oaksystem.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}