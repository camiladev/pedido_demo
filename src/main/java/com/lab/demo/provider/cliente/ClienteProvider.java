package com.lab.demo.provider.cliente;

import com.lab.demo.model.cliente.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteProvider {
    Optional<Cliente> consultaPorId(UUID idCliente);
}
