package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.City;
import com.impacto.algafood.domain.model.Cookery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
