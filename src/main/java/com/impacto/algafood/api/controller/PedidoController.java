package com.impacto.algafood.api.controller;

import com.impacto.algafood.api.assembler.PedidoModelAssembler;
import com.impacto.algafood.api.assembler.PedidoResumoModelAssembler;
import com.impacto.algafood.api.model.PedidoModel;
import com.impacto.algafood.api.model.PedidoResumoModel;
import com.impacto.algafood.domain.model.Pedido;
import com.impacto.algafood.domain.repository.PedidoRepository;
import com.impacto.algafood.domain.service.EmissaoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EmissaoPedidoService emissaoPedido;

    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @Autowired
    private PedidoResumoModelAssembler pedidoResumoModelAssembler;

    @GetMapping
    public List<PedidoResumoModel> listar() {
        return pedidoResumoModelAssembler.toCollectionModel(pedidoRepository.findAll());
    }

    @GetMapping("{pedidoId}")
    public PedidoModel buscar(@PathVariable Long pedidoId) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);
        return pedidoModelAssembler.toModel(pedido);
    }
}
