package com.impacto.algafood.core.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.impacto.algafood.api.model.mixin.RestauranteMixin;
import com.impacto.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
    }
}
