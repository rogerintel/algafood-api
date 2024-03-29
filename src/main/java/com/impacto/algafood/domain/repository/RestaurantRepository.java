package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurante, Long> {
}
