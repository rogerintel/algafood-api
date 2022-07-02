package com.impacto.algafood.infraestruture.repository;

import com.impacto.algafood.domain.model.Restaurant;
import com.impacto.algafood.domain.repository.RestaurantRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> getAll() {
        return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    public Restaurant getById(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Restaurant restaurant = getById(id);
        if (restaurant == null)
            throw new EmptyResultDataAccessException(String.format("Não existe um cadastro de restaurante com código %d", id),1);
        try {
            manager.remove(restaurant);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(String.format("Restaurante de código %d não pode ser removido, pois está em uso", id));
        }
    }
}
