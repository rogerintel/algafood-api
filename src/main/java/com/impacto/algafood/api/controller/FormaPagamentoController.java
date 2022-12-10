package com.impacto.algafood.api.controller;

import com.impacto.algafood.api.assembler.FormaPagamentoModelAssembler;
import com.impacto.algafood.api.assembler.FormaPgamentoInputDisassembler;
import com.impacto.algafood.api.model.FormaPagamentoModel;
import com.impacto.algafood.api.model.input.FormaPagamentoInput;
import com.impacto.algafood.domain.model.FormaPagamento;
import com.impacto.algafood.domain.repository.FormaPagamentoRepository;
import com.impacto.algafood.domain.service.CadastroFormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private FormaPagamentoModelAssembler formaPagamentoModelAssembler;

    @Autowired
    private FormaPgamentoInputDisassembler formaPgamentoInputDisassembler;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;

    @GetMapping
    public List<FormaPagamentoModel> listar() {
        return formaPagamentoModelAssembler.toCollectionModel(formaPagamentoRepository.findAll());
    }

    @GetMapping("/{formaPagamentoId}")
    public FormaPagamentoModel buscar(@PathVariable Long formaPagamentoId) {
        return formaPagamentoModelAssembler.toModel(cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId));
    }

    @PostMapping
    public FormaPagamentoModel adicionar(@RequestBody FormaPagamentoInput formaPagamentoInput) {
        return formaPagamentoModelAssembler.toModel(cadastroFormaPagamento.salvar(formaPgamentoInputDisassembler.toDomainObject(formaPagamentoInput)));
    }

    @PutMapping("/{formaPagamentoId}")
    public FormaPagamentoModel atualizar(@PathVariable Long formaPagamentoId, @RequestBody FormaPagamentoInput formaPagamentoInput) {
        FormaPagamento formaPagamentoAtual = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);

        formaPgamentoInputDisassembler.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);

        return formaPagamentoModelAssembler.toModel(cadastroFormaPagamento.salvar(formaPagamentoAtual));
    }

    @DeleteMapping("/{formaPagamentoId}")
    public void remover(@PathVariable Long formaPagamentoId) {
        cadastroFormaPagamento.excluir(formaPagamentoId);
    }
}
