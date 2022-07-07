package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.model.City;
import com.impacto.algafood.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    public List<City> list() {
        return repository.findAll();
    }

    public Optional<City> find(Long id) {
        return repository.findById(id);
    }

    public City save(City city) {
       return repository.save(city);
    }
}
