package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.model.Restaurant;
import com.impacto.algafood.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> list() {
        return restaurantRepository.findAll();
    }

    public Restaurant find(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

}
