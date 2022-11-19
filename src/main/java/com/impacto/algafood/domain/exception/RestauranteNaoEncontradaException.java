package com.impacto.algafood.domain.exception;

public class RestauranteNaoEncontradaException extends EntidadeNaoEncontradaException {
    public RestauranteNaoEncontradaException(Long restauranteId) {
        super(String.format("Não existe cadastro de restaurante com código %d", restauranteId));
    }
}
