package com.impacto.algafood.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoModel {

    private String codigo;
    private String nomeCliente;
    private String taxaFrete;
    private String subTotal;
    private String valorTotal;
    private String status;
    private String dataCriacao;
    private String formaPagamento;
    private RestauranteResumoModel restaurante;
    private UsuarioModel cliente;
    private EnderecoModel enderecoEntrega;
    private List<ItemPedidoModel> itens;
}
