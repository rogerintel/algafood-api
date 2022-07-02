package com.impacto.algafood.infraestruture.repository;

import com.impacto.algafood.domain.model.Permission;
import com.impacto.algafood.domain.repository.PermissionReposotory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PermissionReposotoryImpl implements PermissionReposotory {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permission> getAll() {
        return manager.createQuery("from Permission", Permission.class).getResultList();
    }

    @Override
    public Permission getById(Long id) {
        return manager.find(Permission.class, id);
    }

    @Transactional
    @Override
    public Permission save(Permission permission) {
        return manager.merge(permission);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Permission permission = getById(id);
        if (permission == null)
            throw new EmptyResultDataAccessException(String.format("Não existe um cadastro de permissão com código %d", id),1);
        try {
            manager.remove(permission);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(String.format("Permissão de código %d não pode ser removida, pois está em uso", id));
        }

    }
}
