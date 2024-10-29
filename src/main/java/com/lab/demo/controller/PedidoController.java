package com.lab.demo.controller;

import com.lab.demo.dto.NovoPedidoDTO;
import com.lab.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dependency Inversion Principle (DIP)
 * Dependa de abstrações, não de classes concretas.
 *
 * A 'PedidoController' depende da abstração 'PedidoService' ao invés de uma implementação concreta.
 * Isso facilita a substituição de 'PedidoServiceImpl' por outra implementação, se necessário.
 */

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<NovoPedidoDTO> criarPedido(@RequestBody NovoPedidoDTO pedido) throws Exception {
        NovoPedidoDTO novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }
}
