package com.impacto.algafood.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SenhaInput {

    @NotBlank
    public String novaSenha;

    @NotBlank
    private String senhaAtual;

}
