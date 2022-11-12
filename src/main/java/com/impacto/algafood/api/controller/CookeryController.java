package com.impacto.algafood.api.controller;

import com.impacto.algafood.domain.model.Cozinha;
import com.impacto.algafood.domain.service.CadastroCozinhaService;
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
    private CadastroCozinhaService service;

    @GetMapping
    public List<Cozinha> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> find(@PathVariable Long id) {
        Optional<Cozinha> cookery = service.findById(id);

        if (cookery.isPresent()) {
            return ResponseEntity.ok(cookery.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha add(@RequestBody Cozinha cozinha) {
        return service.save(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha cozinha) {

        Optional<Cozinha> currentCookery = service.findById(id);

        if (currentCookery.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(cozinha, currentCookery.get(), "id");
        return ResponseEntity.ok(service.save(currentCookery.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
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
