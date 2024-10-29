package com.lab.demo.provider.pedido;

import com.lab.demo.model.pedido.Pedido;
import com.lab.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProviderImpl implements PedidoProvider {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoProviderImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido cadastraNovoPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

}
