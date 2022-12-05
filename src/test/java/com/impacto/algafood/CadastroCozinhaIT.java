package com.impacto.algafood;

import com.impacto.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.impacto.algafood.domain.exception.EntidadeEmUsoException;
import com.impacto.algafood.domain.model.Cozinha;
import com.impacto.algafood.domain.service.CadastroCozinhaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CadastroCozinhaIT {

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Test
    public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome("Chinesa");
        novaCozinha = cadastroCozinha.salvar(novaCozinha);
        assertThat(novaCozinha).isNotNull();
        assertThat(novaCozinha.getId()).isNotNull();
    }

    @Test
    public void testarCadastroCozinhaSemNome() {
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome(null);
        ConstraintViolationException erroEsperado = assertThrows(ConstraintViolationException.class, () -> cadastroCozinha.salvar(novaCozinha));
        assertThat(erroEsperado).isNotNull();
    }

    @Test
    public void deveFalhar_QuandoExcluirCozinhaEmUso() {
        assertThrows(EntidadeEmUsoException.class, () -> cadastroCozinha.excluir(1L));
    }

    @Test
    public void deveFalhar_QuandoExcluirCozinhaInexistente() {
        assertThrows(CozinhaNaoEncontradaException.class, () -> cadastroCozinha.excluir(100L));
    }
}
