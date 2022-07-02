package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.FormPayment;

import java.util.List;

public interface FormPaymentRepository {
    List<FormPayment> getAll();

    FormPayment getById(Long id);

    FormPayment save(FormPayment formPayment);

    void delete(Long id);
}
