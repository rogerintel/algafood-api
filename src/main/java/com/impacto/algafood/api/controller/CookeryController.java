package com.impacto.algafood.api.controller;

import com.impacto.algafood.domain.model.Cookery;
import com.impacto.algafood.domain.repository.CookeryRepository;
import com.impacto.algafood.infraestruture.repository.CookeryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cookerys")
public class CookeryController {

    @Autowired
    private CookeryRepository repository;

    @GetMapping
    public List<Cookery> list() {
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cookery> find(@PathVariable Long id) {
        Cookery cookery = repository.getById(id);

        if (cookery != null) {
            return ResponseEntity.ok(cookery);
        }
        return ResponseEntity.notFound().build();
    }
}
