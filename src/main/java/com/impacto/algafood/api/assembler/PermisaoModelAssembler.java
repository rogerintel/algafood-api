package com.impacto.algafood.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.impacto.algafood.api.model.PermisaoModel;
import com.impacto.algafood.domain.model.Permisao;

@Component
public class PermisaoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public PermisaoModel toModel(Permisao permisao) {
        return modelMapper.map(permisao, PermisaoModel.class);
    }

    public List<PermisaoModel> toCollectionModel(List<Permisao> permisoes) {
        return permisoes.stream()
                .map(permisao -> toModel(permisao))
                .collect(Collectors.toList());
    }
}