package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.State;

import java.util.List;

public interface StateRepository {
    List<State> getAll();
    State getById(Long id);
    State save(State state);
    void delete(Long id);
}
