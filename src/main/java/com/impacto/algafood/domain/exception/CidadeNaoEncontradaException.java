package com.impacto.algafood.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {
    public CidadeNaoEncontradaException(Long cidadeId) {
        super(String.format("Não existe cadastro de cidade com código %d", cidadeId));
    }
}
