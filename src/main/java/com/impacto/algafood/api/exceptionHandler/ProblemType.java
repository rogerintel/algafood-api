package com.impacto.algafood.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("Dados inválidos", "/dados-invalidos"),
    ERRO_DE_SISTEMA("Erro de sistema", "/erro-de-sistema"),
    PARAMETRO_INVALIDO("Parâmetro inválido", "/parametro-invalido"),
    MENSAGEM_INCOMPREENSIVEL("Mensagem incopreensivel", "/mensagem-incopreensivel"),
    RECURSO_NAO_ENCONTRADO("Entidade não encontrada", "/entidade-nao-encontrada"),
    ERRO_NEGOCIO("Erro de negócio", "/erro-negocio"),
    ENTIDADE_EM_USO("Entidade em uso", "/entidade-em-uso");

    private String title;
    private String uri;

    ProblemType(String title, String path) {
        this.title = title;
        this.uri = "https://algafood.com.br" + path;
    }
}
