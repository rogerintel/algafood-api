package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.City;
import com.impacto.algafood.domain.model.Cookery;

import java.util.List;

public interface CityRepository {

    List<City> getAll();
    City getById(Long id);
    City save(City city);
    void delete(City city);

}
