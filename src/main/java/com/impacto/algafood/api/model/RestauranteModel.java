package com.impacto.algafood.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class RestauranteModel {

    private Long id;
    private String nome;
    private BigDecimal precoFrete;
    private CozinhaModel cozinha;
    private Boolean ativo;
    private Boolean aberto;
    private EnderecoModel endereco;
}
