package com.impacto.algafood.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoModel {

    private Long produtoId;
    private String produtoNome;
    private Integer quantidade;
    private Double precoUnitario;
    private Double precoTotal;
    private String observacao;
}
