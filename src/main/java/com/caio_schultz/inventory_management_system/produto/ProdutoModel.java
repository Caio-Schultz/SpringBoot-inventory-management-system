package com.caio_schultz.inventory_management_system.produto;

import com.caio_schultz.inventory_management_system.categoria.CategoriaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private double precoUnitario;
    private String unidadeDeMedida;
    private int quantidadeEmEstoque;
    private int quantidadeMinima;
    private int quantidadeMaxima;
    @ManyToOne
    @JoinColumn(name = "categoria_id") // Foreign key
    private CategoriaModel categoria;

}
