package com.impacto.algafood.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impacto.algafood.domain.model.Cozinha;
import com.impacto.algafood.domain.model.Endereco;
import com.impacto.algafood.domain.model.FormaPagamento;
import com.impacto.algafood.domain.model.Produto;

import java.time.OffsetDateTime;
import java.util.List;

public abstract class RestauranteMixin {

    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Cozinha cozinha;

    @JsonIgnore
    private Endereco endereco;

    @JsonIgnore
    private OffsetDateTime dataCadastro;

    @JsonIgnore
    private OffsetDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento;

    @JsonIgnore
    private List<Produto> produtos;
}
