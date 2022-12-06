package com.impacto.algafood.api.assembler;

import com.impacto.algafood.api.model.input.RestauranteInput;
import com.impacto.algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurnateInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public RestaurnateInputDisassembler() {
    }

    public Restaurante toEntity(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }
}