package com.impacto.algafood.core.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValorZeroIncluiDescricaoValidator.class})
public @interface ValorZeroIncluiDescricao {

        String message() default "Descrição obrigatória inválida";

        Class<?>[] groups() default {};

        Class<? extends javax.validation.Payload>[] payload() default {};

        String valorField();

        String descricaoField();

        String descricaoObrigatoria();
}
