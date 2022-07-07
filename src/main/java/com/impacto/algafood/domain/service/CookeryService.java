package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.model.Cookery;
import com.impacto.algafood.domain.repository.CookeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookeryService {
    @Autowired
    private CookeryRepository repository;
    public Cookery save(Cookery cookery) {
        return repository.save(cookery);
    }

    public void delete(Long id) {
            repository.deleteById(id);
    }

    public List<Cookery> findAll() {
        return repository.findAll();
    }

    public Optional<Cookery> findById(Long id) {
        return repository.findById(id);
    }
}
