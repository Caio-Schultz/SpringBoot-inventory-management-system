package com.caio_schultz.inventory_management_system.produto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public List<ProdutoDTO> listarProdutos(){
        List<ProdutoModel> produtos = produtoRepository.findAll();
        if(!produtos.isEmpty()){
        return produtos.stream()
                    .map(produtoMapper::map)
                    .collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    public ProdutoDTO listarProdutoPorId(Long id){
        Optional<ProdutoModel> produtoModel = produtoRepository.findById(id);
        return produtoModel.map(produtoMapper::map).orElse(null);
    }

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO){
        ProdutoModel produtoCriado = produtoRepository.save(produtoMapper.map(produtoDTO));
        return produtoMapper.map(produtoCriado);
    }



}
