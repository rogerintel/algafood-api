package com.impacto.algafood.infraestruture.repository;

import com.impacto.algafood.domain.model.City;
import com.impacto.algafood.domain.repository.CityRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<City> getAll() {
        return manager.createQuery("from City", City.class).getResultList();
    }

    @Transactional
    @Override
    public City getById(Long id) {
        return manager.find(City.class, id);
    }

    @Transactional
    @Override
    public City save(City city) {
        return manager.merge(city);
    }

    @Override
    public void delete(City city) {
        manager.remove(getById(city.getId()));
    }
}
