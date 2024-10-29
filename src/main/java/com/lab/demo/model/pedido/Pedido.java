package com.lab.demo.model.pedido;

import com.lab.demo.model.produto.Produto;
import com.lab.demo.model.cliente.Cliente;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Exemplo de classe sem usar a anotação @Data, com os getter e setter criados manualmente.
 */

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido")
    private List<Produto> produtos;

    @Column(name = "dt_compra", nullable = false)
    private LocalDateTime dataCompra;

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * Construtor sem argumentos necessário para que o JPA possa instanciar
     * a entidade e para permitir herança em 'PedidoRapido'
     */
    public Pedido(){}

    public Pedido(UUID id, Cliente cliente, List<Produto> listaProdutos) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = listaProdutos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
