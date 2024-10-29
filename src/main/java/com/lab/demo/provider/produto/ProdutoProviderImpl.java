package com.lab.demo.provider.produto;

import com.lab.demo.model.produto.Produto;
import com.lab.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ProdutoProviderImpl implements ProdutoProvider {
    private final ProdutoRepository produtoRepository;

    public ProdutoProviderImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public Optional<Produto> consultaPorId(UUID idProduto) {
        return produtoRepository.findById(idProduto);
    }
}
