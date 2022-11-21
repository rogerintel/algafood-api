package com.impacto.algafood.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum PloblemType {

    ENTIDADE_NAO_ENCONTRADA("Entidade não encontrada", "/entidade-nao-encontrada"),
    ERRO_NEGOCIO("Erro de negócio", "/erro-negocio"),
    ENTIDADE_EM_USO("Entidade em uso", "/entidade-em-uso");

    private String title;
    private String uri;

    PloblemType (String title, String path) {
        this.title = title;
        this.uri = "https://algafood.com.br" + path;
    }
}
