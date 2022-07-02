package com.impacto.algafood.infraestruture.repository;

import com.impacto.algafood.domain.model.FormPayment;
import com.impacto.algafood.domain.repository.FormPaymentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormPaymentRepositoryImpl implements FormPaymentRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormPayment> getAll() {
        return manager.createQuery("from FormPayment", FormPayment.class).getResultList();
    }

    @Override
    public FormPayment getById(Long id) {
        return manager.find(FormPayment.class, id);
    }

    @Override
    public FormPayment save(FormPayment formPayment) {
        return manager.merge(formPayment);
    }

    @Override
    public void delete(Long id) {
        FormPayment formPayment = getById(id);
        if (formPayment == null)
            throw new EmptyResultDataAccessException(String.format("Não existe um cadastro de forma de pagamento com código %d", id),1);
        try {
            manager.remove(formPayment);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(String.format("Forma de pagamento de código %d não pode ser removida, pois está em uso", id));
        }

    }
}
