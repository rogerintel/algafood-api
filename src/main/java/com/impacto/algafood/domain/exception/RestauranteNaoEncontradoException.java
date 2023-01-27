package com.impacto.algafood.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {
    public RestauranteNaoEncontradoException(Long restauranteId) {
        super(String.format("Não existe cadastro de restaurante com código %d", restauranteId));
    }
}
