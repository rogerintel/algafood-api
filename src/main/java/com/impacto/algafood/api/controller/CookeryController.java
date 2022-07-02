package com.impacto.algafood.api.controller;

import com.impacto.algafood.domain.model.Cookery;
import com.impacto.algafood.domain.repository.CityRepository;
import com.impacto.algafood.domain.repository.CookeryRepository;
import com.impacto.algafood.domain.service.CookeryService;
import com.impacto.algafood.infraestruture.repository.CookeryRepositoryImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cookerys")
public class CookeryController {

    @Autowired
    private CookeryRepository repository;
    @Autowired
    private CookeryService service;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cookery add(@RequestBody Cookery cookery) {
        return service.save(cookery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cookery> update(@PathVariable Long id, @RequestBody Cookery cookery) {
        Cookery currentCookery = repository.getById(id);

        if(currentCookery == null)
            return ResponseEntity.notFound().build();

        BeanUtils.copyProperties(cookery, currentCookery, "id");
        currentCookery = service.save(cookery);
        return ResponseEntity.ok(currentCookery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cookery> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
