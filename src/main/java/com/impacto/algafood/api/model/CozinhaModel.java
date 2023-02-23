package com.impacto.algafood.api.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.impacto.algafood.api.model.view.RestauranteView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CozinhaModel {

    @JsonView(RestauranteView.Resumo.class)
    private Long id;

    @JsonView(RestauranteView.Resumo.class)
    private String nome;

    public CozinhaModel(Long id) {
        this.id = id;
    }
}
