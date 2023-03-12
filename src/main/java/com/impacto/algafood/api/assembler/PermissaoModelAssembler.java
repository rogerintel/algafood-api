package com.impacto.algafood.api.assembler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.impacto.algafood.api.model.PermissaoModel;
import com.impacto.algafood.domain.model.Permissao;

@Component
public class PermissaoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public PermissaoModel toModel(Permissao permisao) {
        return modelMapper.map(permisao, PermissaoModel.class);
    }

    public List<PermissaoModel> toCollectionModel(Set<Permissao> set) {
        return set.stream()
                .map(permisao -> toModel(permisao))
                .collect(Collectors.toList());
    }
}