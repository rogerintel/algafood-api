package com.impacto.algafood.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultiploValidator implements ConstraintValidator<Multiplo, Number> {

    private int numeroMultiplo;

    @Override
    public void initialize(Multiplo constraintAnnotation) {
        this.numeroMultiplo = constraintAnnotation.numero();
    }

    @Override
    public boolean isValid(Number number, ConstraintValidatorContext constraintValidatorContext) {
        if (number != null) {
            var valorDecimal = number.doubleValue();
            var multiploDecimal = this.numeroMultiplo * 1.0;
            var resto = valorDecimal % multiploDecimal;
            return resto == 0;
        }
        return true;
    }
}
