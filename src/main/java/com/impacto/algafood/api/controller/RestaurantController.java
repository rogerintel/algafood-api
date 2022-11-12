package com.impacto.algafood.api.controller;

import com.impacto.algafood.domain.model.Restaurante;
import com.impacto.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<Restaurante> list() {
        return cadastroRestauranteService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> find(@PathVariable Long id) {
        Restaurante restaurante = cadastroRestauranteService.find(id);

        if (restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody Restaurante restaurante) {
        try {
            cadastroRestauranteService.save(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        try {
            Restaurante currentRestaurante = cadastroRestauranteService.find(id);

            if(currentRestaurante == null)
                return ResponseEntity.notFound().build();

            BeanUtils.copyProperties(restaurante, currentRestaurante, "id");
            currentRestaurante = cadastroRestauranteService.save(currentRestaurante);
            return ResponseEntity.ok(currentRestaurante);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
