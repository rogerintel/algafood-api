package com.impacto.algafood.domain.exception;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {
    public CozinhaNaoEncontradaException(Long cozinhaId) {
        super(String.format("Não existe cadastro de cidade com código %d", cozinhaId));
    }
}
