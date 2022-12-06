package com.impacto.algafood.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.impacto.algafood.domain.model.Restaurante;

import java.util.List;

public abstract class CozinhaMixin {

    @JsonIgnore
    private List<Restaurante> restaurantes;
}
