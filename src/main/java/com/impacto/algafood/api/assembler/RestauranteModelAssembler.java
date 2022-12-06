package com.impacto.algafood.api.assembler;

import com.impacto.algafood.api.model.CozinhaModel;
import com.impacto.algafood.api.model.RestauranteModel;
import com.impacto.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteModelAssembler {
    public RestauranteModelAssembler() {
    }

    public RestauranteModel toModel(Restaurante restaurante) {
        CozinhaModel cozinhaModel = new CozinhaModel(restaurante.getCozinha().getId(), restaurante.getCozinha().getNome());
        return new RestauranteModel(restaurante.getId(), restaurante.getNome(), restaurante.getTaxaFrete(), cozinhaModel);
    }

    public List<RestauranteModel> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}