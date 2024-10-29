package com.lab.demo.provider.cliente;

import com.lab.demo.model.cliente.Cliente;
import com.lab.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteProviderImpl implements ClienteProvider {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteProviderImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> consultaPorId(UUID idCliente) {
        return clienteRepository.findById(idCliente);
    }

}
