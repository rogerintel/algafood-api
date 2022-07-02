package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.Cookery;

import java.util.List;

public interface CookeryRepository {

    List<Cookery> getAll();
    Cookery getById(Long id);
    Cookery save(Cookery cookery);
    void delete(Long id);

}
