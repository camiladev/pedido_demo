package com.lab.demo.service;

import com.lab.demo.dto.NovoPedidoDTO;
import com.lab.demo.model.pedido.Pedido;

import java.util.List;

/**
 * Interface Segregation Principle (ISP)
 * Uma classe não pode ser forçada a implementar interfaces que ela não usa.
 *
 * As interfaces são dividas para que cada uma tenha métodos específicos e não
 * obriguem as classes a implementar métodos que não utilizam,
 */

public interface PedidoService {
    NovoPedidoDTO criarPedido(NovoPedidoDTO pedido) throws Exception;
    Pedido atualizarPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    void excluirPedido(Long id);
}
