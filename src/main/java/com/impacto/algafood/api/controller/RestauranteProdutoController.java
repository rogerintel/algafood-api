package com.impacto.algafood.api.controller;

import com.impacto.algafood.api.assembler.ProdutoInputDisassembler;
import com.impacto.algafood.api.assembler.ProdutoModelAssembler;
import com.impacto.algafood.api.model.ProdutoInput;
import com.impacto.algafood.api.model.ProdutoModel;
import com.impacto.algafood.domain.model.Produto;
import com.impacto.algafood.domain.service.CadastroProdutoService;
import com.impacto.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos/{produtoId}")
public class RestauranteProdutoController {

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private ProdutoModelAssembler produtoModelAssembler;

    @Autowired
    private ProdutoInputDisassembler produtoInputDisassembler;

    @Autowired
    private CadastroProdutoService cadastroProduto;

    @GetMapping
    public List<ProdutoModel> listar(@PathVariable Long restauranteId) {
        var restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return produtoModelAssembler.toCollectionModel(restaurante.getProdutos());
    }

    @GetMapping("/{produtoId}")
    public ProdutoModel buscar(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
        Produto produto = cadastroProduto.buscarOuFalhar(restauranteId, produtoId);

        return produtoModelAssembler.toModel(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel adicionar(@PathVariable Long restauranteId, @RequestBody Produto produto) {
        var restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        produto.setRestaurante(restaurante);
        produto = cadastroProduto.salvar(produto);

        return produtoModelAssembler.toModel(produto);
    }

    @PutMapping("/{produtoId}")
    public ProdutoModel atualizar(@PathVariable Long restauranteId, @PathVariable Long produtoId,
            @RequestBody ProdutoInput produtoInput) {

        var produtoAtual = cadastroProduto.buscarOuFalhar(restauranteId, produtoId);

        produtoInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);

        produtoAtual = cadastroProduto.salvar(produtoAtual);

        return produtoModelAssembler.toModel(produtoAtual);
    }
}
