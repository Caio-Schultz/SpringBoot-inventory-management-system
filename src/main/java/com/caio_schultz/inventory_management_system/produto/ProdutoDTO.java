package com.caio_schultz.inventory_management_system.produto;

import com.caio_schultz.inventory_management_system.categoria.CategoriaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private double precoUnitario;
    private String unidadeDeMedida;
    private int quantidadeEmEstoque;
    private int quantidadeMinima;
    private int quantidadeMaxima;
    private CategoriaModel categoria;

}
