package com.lab.demo.model.produto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * A anotação @Data é parte do framework Lombok e é usada para gerar automaticamente
 * os métodos getter e setter, toString, hashCode, equals, e um construtor sem argumentos
 * para a classe anotada.
 *
 * Reduz a necessidade de escrever código boilerplate manualmente.
 */

@Data
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "valor", nullable = false)
    private Double valor;
}
