package com.caio_schultz.inventory_management_system.produto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping("/listar")
    public ResponseEntity<?> listarProdutos(){
        List<ProdutoDTO> produtos = produtoService.listarProdutos();
        if(produtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há produtos na lista!");
        }
        else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(produtos);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarProdutosPorId(@PathVariable Long id){
        ProdutoDTO produtoDTO = produtoService.listarProdutoPorId(id);
        if(produtoDTO != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(produtoDTO);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDTO produtoDTO){
        produtoService.criarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto cadastrado com sucesso!");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        if(produtoService.listarProdutoPorId(id) != null){
            produtoService.atualizarProduto(id, produtoDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Produto atualizado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum produto!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProdutoPorId(@PathVariable Long id){
        if(produtoService.listarProdutoPorId(id) != null) {
            produtoService.deletarProdutoPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Produto deletado com sucesso!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum produto!");
        }

    }


}
