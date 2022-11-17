package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.impacto.algafood.domain.model.Cozinha;
import com.impacto.algafood.domain.model.Restaurante;
import com.impacto.algafood.domain.repository.CozinhaRepository;
import com.impacto.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    public static final String MSG_RESTAURANTE_NAO_EXISTE = "Não existe cadastro de restaurante com código %d";
    public static final String MSG_COZINHA_NAO_EXISTE = "Não existe cadastro de cozinha com código %d";
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_COZINHA_NAO_EXISTE, cozinhaId)));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscarOuFalhar(Long restauranteId) {
        return restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_RESTAURANTE_NAO_EXISTE, restauranteId)));
    }
}
