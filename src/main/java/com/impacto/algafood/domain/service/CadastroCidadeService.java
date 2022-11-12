package com.impacto.algafood.domain.service;

import com.impacto.algafood.domain.model.Cidade;
import com.impacto.algafood.domain.repository.CidadeRepository;
import com.impacto.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroCidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> list() {
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> find(Long id) {
        return cidadeRepository.findById(id);
    }

    public Cidade salvar(Cidade cidade) {
       return cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {

    }
}
