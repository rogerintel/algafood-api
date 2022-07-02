package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.model.Cookery;
import com.impacto.algafood.domain.repository.CookeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CookeryService {
    @Autowired
    private CookeryRepository repository;
    public Cookery save(Cookery cookery) {
        return repository.save(cookery);
    }

    public void delete(Long id) {
            repository.delete(id);
    }
}
