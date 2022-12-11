package com.impacto.algafood.domain.exception;

import java.io.Serial;
import java.lang.constant.ConstantDesc;

public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public GrupoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    public GrupoNaoEncontradoException(ConstantDesc grupoId) {
        super("Não existe um cadastro de grupo com código " + grupoId);
    }
}
