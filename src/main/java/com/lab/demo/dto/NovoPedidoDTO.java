package com.lab.demo.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class NovoPedidoDTO {
    private UUID id = null;
    private UUID idCliente;
    private List<UUID> listaProdutosId;
}
