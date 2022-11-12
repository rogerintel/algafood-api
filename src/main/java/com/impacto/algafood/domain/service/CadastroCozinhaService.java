package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.model.Cozinha;
import com.impacto.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroCozinhaService {
    @Autowired
    private CozinhaRepository repository;
    public Cozinha save(Cozinha cozinha) {
        return repository.save(cozinha);
    }

    public void delete(Long id) {
            repository.deleteById(id);
    }

    public List<Cozinha> findAll() {
        return repository.findAll();
    }

    public Optional<Cozinha> findById(Long id) {
        return repository.findById(id);
    }
}
