package com.impacto.algafood.api.assembler;

import com.impacto.algafood.api.model.CozinhaModel;
import com.impacto.algafood.api.model.input.RestauranteInput;
import com.impacto.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestaurnateInputDisassembler {
    public RestaurnateInputDisassembler() {
    }

    public Restaurante toEntity(RestauranteInput restauranteInput) {
        return new Restaurante(restauranteInput.getNome(), restauranteInput.getTaxaFrete(),
                new CozinhaModel(restauranteInput.getCozinha().getId()));
    }
}