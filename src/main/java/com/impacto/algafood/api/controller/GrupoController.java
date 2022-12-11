package com.impacto.algafood.api.controller;

import com.impacto.algafood.api.assembler.GrupoInputDisassembler;
import com.impacto.algafood.api.assembler.GrupoModelAssembler;
import com.impacto.algafood.api.model.GrupoModel;
import com.impacto.algafood.api.model.input.GrupoInput;
import com.impacto.algafood.domain.model.Grupo;
import com.impacto.algafood.domain.repository.GrupoRepository;
import com.impacto.algafood.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private CadastroGrupoService cadastroGrupoService;

    @Autowired
    private GrupoModelAssembler grupoModelAssembler;

    @Autowired
    private GrupoInputDisassembler grupoInputDisassembler;

    @GetMapping
    public List<GrupoModel> listar() {
        return grupoModelAssembler.toCollectionModel(grupoRepository.findAll());
    }

    @GetMapping("/{grupoId}")
    public GrupoModel buscar(@PathVariable Long grupoId) {
        return grupoModelAssembler.toModel(cadastroGrupoService.buscarOuFalhar(grupoId));
    }

    @PostMapping
    public GrupoModel adicionar(@RequestBody GrupoInput grupoInput) {
        return grupoModelAssembler.toModel(cadastroGrupoService.salvar(grupoInputDisassembler.toDomainObject(grupoInput)));
    }

    @PutMapping("/{grupoId}")
    public GrupoModel atualizar(@PathVariable Long grupoId, @RequestBody GrupoInput grupoInput) {
        Grupo grupoAtual = cadastroGrupoService.buscarOuFalhar(grupoId);
        grupoInputDisassembler.copyToDomainOnject(grupoInput, grupoAtual);
        return grupoModelAssembler.toModel(cadastroGrupoService.salvar(grupoAtual));
    }

    @DeleteMapping("/{grupoId}")
    public void remover(@PathVariable Long grupoId) {
        cadastroGrupoService.excluir(grupoId);
    }
}
