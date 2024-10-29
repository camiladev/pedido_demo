package com.lab.demo.mapper.pedido;

import com.lab.demo.dto.NovoPedidoDTO;
import com.lab.demo.model.cliente.Cliente;
import com.lab.demo.model.pedido.Pedido;
import com.lab.demo.model.produto.Produto;

import java.util.List;

public interface PedidoMapper {
    NovoPedidoDTO toNovoPedidoDTO(Pedido pedido);
    Pedido toPedido(NovoPedidoDTO novoPedidoDTO, Cliente cliente, List<Produto> listaProduto);
}
