package com.lab.demo.provider.produto;

import com.lab.demo.model.produto.Produto;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoProvider {

    Optional<Produto> consultaPorId(UUID idProduto);

}
