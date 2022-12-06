package com.impacto.algafood.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CozinhaModel {

    private Long id;
    private String nome;

    public CozinhaModel(Long id) {
        this.id = id;
    }
}
