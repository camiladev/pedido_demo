package com.lab.demo.model.cliente;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Single Responsibility Principle (SRP)
 * Cada classe deve ter uma única responsabilidade
 *
 * A classe Cliente só lida com informações de pedidos
 */

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;
}
