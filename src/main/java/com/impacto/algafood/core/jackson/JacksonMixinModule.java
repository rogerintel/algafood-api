package com.impacto.algafood.core.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.impacto.algafood.api.model.mixin.CidadeMixin;
import com.impacto.algafood.api.model.mixin.CozinhaMixin;
import com.impacto.algafood.api.model.mixin.RestauranteMixin;
import com.impacto.algafood.domain.model.Cidade;
import com.impacto.algafood.domain.model.Cozinha;
import com.impacto.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }
}
