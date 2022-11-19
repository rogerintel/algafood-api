package com.impacto.algafood.domain.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {
    public EstadoNaoEncontradoException(Long estadoId) {
        super(String.format("Não existe cadastro de estado com código %d", estadoId));
    }
}
