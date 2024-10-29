package com.lab.demo.model.pedido;

import com.lab.demo.model.produto.Produto;
import com.lab.demo.model.cliente.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

/**
 * Liskov Substitution Principle (LSP)
 * As subclasses devem ser substituíveis pelas superclasses.
 *
 * A classe 'PedidoRapido' pode substituit 'Pedido' em qualquer lugar onde 'Pedido' é esperado, sem quebrar a lógica do aplicativo.
 */

@Entity
//@Table(name = "tb_pedido_rapido")
public class PedidoRapido extends Pedido {

    @Column(name = "tempoEntrega")
    private int tempoEntrega;

    // Contrutor sem argumentos que chama o construtor padrão da superclasse 'Pedido'
    public PedidoRapido() {
        super();
    }

    /**
     * Um construtor que aceita parâmetros e chama o construtor da superclasse (Pedido),
     * além de inicializar o campo tempoEntrega
     */
    public PedidoRapido(UUID id, Cliente cliente, List<Produto> listaProdutos, int tempoEntrega) {
        super(id, cliente, listaProdutos);
        this.tempoEntrega = tempoEntrega;
    }

    public int getTempoEntrega() {
        return tempoEntrega;
    }

    public void setTempoEntrega(int tempoEntrega) {
        this.tempoEntrega = tempoEntrega;
    }
}
