package com.impacto.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.impacto.algafood.api.assembler.PermisaoModelAssembler;
import com.impacto.algafood.api.model.PermisaoModel;
import com.impacto.algafood.domain.model.Grupo;
import com.impacto.algafood.domain.service.CadastroGrupoService;

@RestController
@RequestMapping("/grupos/{grupoId}/permisoes")
public class GrupoPermissaoController {

    @Autowired
    private CadastroGrupoService cadastroGrupo;
    
    @Autowired
    private PermisaoModelAssembler permisaoModelAssembler;
    
    @GetMapping
    public List<PermisaoModel> listar(@PathVariable Long grupoId) {
        Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);
        
        return permisaoModelAssembler.toCollectionModel(grupo.getPermisoes());
    }
    
    @PutMapping("/{permisaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar(@PathVariable Long grupoId, @PathVariable Long permisaoId) {
        cadastroGrupo.associarPermisao(grupoId, permisaoId);
    }
    
    @DeleteMapping("/{permisaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar(@PathVariable Long grupoId, @PathVariable Long permisaoId) {
        cadastroGrupo.desassociarPermisao(grupoId, permisaoId);
    }
}