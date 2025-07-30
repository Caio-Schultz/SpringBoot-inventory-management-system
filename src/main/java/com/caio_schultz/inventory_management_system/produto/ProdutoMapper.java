package com.caio_schultz.inventory_management_system.produto;

import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoModel map(ProdutoDTO produtoDTO){
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produtoDTO.getId());
        produtoModel.setNome(produtoDTO.getNome());
        produtoModel.setPrecoUnitario(produtoDTO.getPrecoUnitario());
        produtoModel.setUnidadeDeMedida(produtoDTO.getUnidadeDeMedida());
        produtoModel.setQuantidadeEmEstoque(produtoDTO.getQuantidadeEmEstoque());
        produtoModel.setQuantidadeMinima(produtoDTO.getQuantidadeMinima());
        produtoModel.setQuantidadeMaxima(produtoDTO.getQuantidadeMaxima());
        produtoModel.setCategoria(produtoDTO.getCategoria());

        return produtoModel;
    }


    public ProdutoDTO map(ProdutoModel produtoModel){
        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setId(produtoModel.getId());
        produtoDTO.setNome(produtoModel.getNome());
        produtoDTO.setPrecoUnitario(produtoModel.getPrecoUnitario());
        produtoDTO.setUnidadeDeMedida(produtoModel.getUnidadeDeMedida());
        produtoDTO.setQuantidadeEmEstoque(produtoModel.getQuantidadeEmEstoque());
        produtoDTO.setQuantidadeMinima(produtoModel.getQuantidadeMinima());
        produtoDTO.setQuantidadeMaxima(produtoModel.getQuantidadeMaxima());
        produtoDTO.setCategoria(produtoModel.getCategoria());

        return produtoDTO;
    }
}
