package com.caio_schultz.inventory_management_system.produto;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
}
