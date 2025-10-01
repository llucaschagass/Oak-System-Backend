package br.com.oaksystem.oaksystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tamanho tamanho;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Embalagem embalagem;
}