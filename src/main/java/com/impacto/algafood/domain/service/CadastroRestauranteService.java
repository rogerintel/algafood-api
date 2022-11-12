package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.model.Restaurante;
import com.impacto.algafood.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurante> list() {
        return restaurantRepository.findAll();
    }

    public Restaurante find(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public Restaurante save(Restaurante restaurante) {
        return restaurantRepository.save(restaurante);
    }

    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

}
