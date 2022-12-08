package com.impacto.algafood.api.assembler;

import com.impacto.algafood.api.model.input.EstadoInput;
import com.impacto.algafood.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Estado toEntity(EstadoInput estadoInput) {
        return modelMapper.map(estadoInput, Estado.class);
    }

    public void copyToDomainObject(EstadoInput estadoInput, Estado estadoAtual) {
        modelMapper.map(estadoInput, estadoAtual);
    }
}
