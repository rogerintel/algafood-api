package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormPaymentRepository extends JpaRepository<FormaPagamento, Long> {
}
