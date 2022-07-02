package com.impacto.algafood.infraestruture.repository;

import com.impacto.algafood.domain.model.Cookery;
import com.impacto.algafood.domain.repository.CookeryRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CookeryRepositoryImpl implements CookeryRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cookery> getAll() {
        return manager.createQuery("from Cookery", Cookery.class).getResultList();
    }

    @Override
    public Cookery getById(Long id) {
        return manager.find(Cookery.class, id);
    }

    @Transactional
    @Override
    public Cookery save(Cookery cookery) {
        return manager.merge(cookery);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Cookery cookery = getById(id);
        if (cookery == null)
            throw new EmptyResultDataAccessException(String.format("Não existe um cadastro de cozinha com código %d", id),1);
        try {
            manager.remove(cookery);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(String.format("Cozinha de código %d não pode ser removida, pois está em uso", id));
        }
    }
}
