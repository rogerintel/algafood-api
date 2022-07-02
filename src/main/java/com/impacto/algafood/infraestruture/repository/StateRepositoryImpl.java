package com.impacto.algafood.infraestruture.repository;

import com.impacto.algafood.domain.model.State;
import com.impacto.algafood.domain.repository.StateRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<State> getAll() {
        return manager.createQuery("from State", State.class).getResultList();
    }

    @Override
    public State getById(Long id) {
        return manager.find(State.class, id);
    }

    @Transactional
    @Override
    public State save(State state) {
        return manager.merge(state);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        State state = getById(id);
        if (state == null)
            throw new EmptyResultDataAccessException(String.format("Não existe um cadastro de estado com código %d", id),1);
        try {
            manager.remove(state);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(String.format("Estado de código %d não pode ser removido, pois está em uso", id));
        }
    }
}
