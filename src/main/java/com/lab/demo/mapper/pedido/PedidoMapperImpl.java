package com.lab.demo.mapper.pedido;

import com.lab.demo.dto.NovoPedidoDTO;
import com.lab.demo.model.cliente.Cliente;
import com.lab.demo.model.pedido.Pedido;
import com.lab.demo.model.produto.Produto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public NovoPedidoDTO toNovoPedidoDTO(Pedido pedido) {
        NovoPedidoDTO novoDTO = new NovoPedidoDTO();
        novoDTO.setId(pedido.getId());
        novoDTO.setIdCliente(pedido.getCliente().getId());

        // Converter a lista de produtos para uma lista de IDs de produto
        List<UUID> listaProdutosId = pedido.getProdutos()
                .stream()
                .map(Produto::getId)
                .collect(Collectors.toList());
        novoDTO.setListaProdutosId(listaProdutosId);

        return novoDTO;
    }

    @Override
    public Pedido toPedido(NovoPedidoDTO novoPedidoDTO, Cliente cliente, List<Produto> listaProduto) {
        Pedido novoPedido = new Pedido();
        novoPedido.setCliente(cliente);
        novoPedido.setProdutos(listaProduto);
        novoPedido.setDataCompra(LocalDateTime.now());
        return null;
    }

}
