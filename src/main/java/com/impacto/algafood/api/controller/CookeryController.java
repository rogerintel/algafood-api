package com.impacto.algafood.api.controller;

import com.impacto.algafood.domain.model.Cookery;
import com.impacto.algafood.domain.service.CookeryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cookerys")
public class CookeryController {

    @Autowired
    private CookeryService service;

    @GetMapping
    public List<Cookery> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cookery> find(@PathVariable Long id) {
        Optional<Cookery> cookery = service.findById(id);

        if (cookery.isPresent()) {
            return ResponseEntity.ok(cookery.get());
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

        Optional<Cookery> currentCookery = service.findById(id);

        if (currentCookery.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(cookery, currentCookery.get(), "id");
        return ResponseEntity.ok(service.save(currentCookery.get()));
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
