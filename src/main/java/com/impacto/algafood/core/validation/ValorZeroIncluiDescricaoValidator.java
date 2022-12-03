package com.impacto.algafood.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class ValorZeroIncluiDescricaoValidator implements ConstraintValidator<ValorZeroIncluiDescricao, Object> {

    private String valorField;
    private String descricaoField;
    private String descricaoObrigatoria;

    @Override
    public void initialize(ValorZeroIncluiDescricao constraintAnnotation) {
        this.valorField = constraintAnnotation.valorField();
        this.descricaoField = constraintAnnotation.descricaoField();
        this.descricaoObrigatoria = constraintAnnotation.descricaoObrigatoria();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        try {
            var valor = (BigDecimal) o.getClass().getField(valorField).get(o);
            var descricao = (String) o.getClass().getField(descricaoField).get(o);

            if (valor != null && BigDecimal.ZERO.compareTo(valor) == 0 && descricao != null) {
                return descricao.toLowerCase().contains(this.descricaoObrigatoria.toLowerCase());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
