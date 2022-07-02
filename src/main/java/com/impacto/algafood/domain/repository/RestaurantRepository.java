package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getAll();
    Restaurant getById(Long id);
    Restaurant save(Restaurant restaurant);
    void delete(Long id);
}
