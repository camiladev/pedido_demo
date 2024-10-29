package com.lab.demo.service;

import com.lab.demo.dto.NovoPedidoDTO;
import com.lab.demo.mapper.pedido.PedidoMapper;
import com.lab.demo.model.cliente.Cliente;
import com.lab.demo.model.pedido.Pedido;
import com.lab.demo.model.produto.Produto;
import com.lab.demo.provider.cliente.ClienteProvider;
import com.lab.demo.provider.pedido.PedidoProvider;
import com.lab.demo.provider.produto.ProdutoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Open/Closed Principle (OCP)
 * As classes devem estar abertas para extensão, mas fechadas para modificação.
 *
 * A classe PedidoServiceImpl pode ser estendida com novos métodos sem alterar os métodos existentes.
 *
 */

@Service
public class PedidoServiceImpl implements PedidoService{

    private final PedidoProvider pedidoProvider;
    private final ClienteProvider clienteProvider;
    private final ProdutoProvider produtoProvider;
    private PedidoMapper pedidoMapper;

    @Autowired
    public PedidoServiceImpl(PedidoProvider pedidoProvider, ClienteProvider clienteProvider, ProdutoProvider produtoProvider) {
        this.pedidoProvider = pedidoProvider;
        this.clienteProvider = clienteProvider;
        this.produtoProvider = produtoProvider;
    }

    @Override
    public NovoPedidoDTO criarPedido(NovoPedidoDTO pedidoDTO) throws Exception {
        Optional<Cliente> cliente = clienteProvider.consultaPorId(pedidoDTO.getIdCliente());
        if (cliente.isEmpty()) {
            throw new Exception("Cliente não encontrado");
        }
        List<Produto> listaProdutos = new ArrayList<>();

        pedidoDTO.getListaProdutosId().forEach( idProduto ->{
            Optional<Produto> produto = produtoProvider.consultaPorId(idProduto);
            produto.ifPresent(listaProdutos::add);
        }
        );

        Pedido pedido = pedidoProvider.cadastraNovoPedido(pedidoMapper.toPedido(pedidoDTO, cliente.get(), listaProdutos));

        return pedidoMapper.toNovoPedidoDTO(pedido);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        return pedido;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return List.of();
    }

    @Override
    public void excluirPedido(Long id) {

    }
}
