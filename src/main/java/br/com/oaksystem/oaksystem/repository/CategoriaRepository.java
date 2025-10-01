package br.com.oaksystem.oaksystem.repository;

import br.com.oaksystem.oaksystem.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}