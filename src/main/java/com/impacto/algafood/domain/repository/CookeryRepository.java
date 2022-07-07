package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.Cookery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CookeryRepository extends JpaRepository<Cookery, Long> {

}
