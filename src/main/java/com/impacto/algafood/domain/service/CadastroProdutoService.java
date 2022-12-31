package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.exception.ProdutoNaoEncontradoException;
import com.impacto.algafood.domain.model.Produto;
import com.impacto.algafood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarOuFalhar(Long restauranteId, Long produtoId) {
        return produtoRepository.findById(restauranteId, produtoId)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(restauranteId, produtoId));
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
}
