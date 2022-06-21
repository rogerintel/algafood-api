package com.impacto.algafood.infraestruture.repository;

import com.impacto.algafood.domain.model.Cookery;
import com.impacto.algafood.domain.repository.CookeryRepository;
import org.springframework.stereotype.Component;

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

    @Override
    public Cookery save(Cookery cookery) {
        return manager.merge(cookery);
    }

    @Override
    public void delete(Cookery cookery) {
        manager.remove(getById(cookery.getId()));
    }
}
