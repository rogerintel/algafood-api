package com.impacto.algafood.api.assembler;

import com.impacto.algafood.api.model.input.RestauranteInput;
import com.impacto.algafood.domain.model.Cidade;
import com.impacto.algafood.domain.model.Cozinha;
import com.impacto.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurnateInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Restaurante toEntity(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

    public void copyToDomainObject(RestauranteInput restauranteInput, Restaurante restaurante) {
        restaurante.setCozinha(new Cozinha());

        if (restaurante.getEndereco() != null) {
            restaurante.getEndereco().setCidade(new Cidade());
        }
        modelMapper.map(restauranteInput, restaurante);
    }
}