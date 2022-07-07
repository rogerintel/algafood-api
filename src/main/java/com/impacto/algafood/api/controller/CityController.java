package com.impacto.algafood.api.controller;

import com.impacto.algafood.domain.model.City;
import com.impacto.algafood.domain.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/citys")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> list() {
        return cityService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> find(@PathVariable Long id) {
        City city = cityService.find(id).orElse(null);

        if (city != null) {
            return ok(city);
        }

        return notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody City city) {
        try {
            city = cityService.save(city);
            return status(HttpStatus.CREATED).body(city);
        } catch (DataIntegrityViolationException e) {
            return badRequest().body(e.getMessage());
        }
    }
}
