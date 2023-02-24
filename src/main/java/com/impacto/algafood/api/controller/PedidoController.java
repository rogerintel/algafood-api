package com.impacto.algafood.api.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.impacto.algafood.api.assembler.PedidoInputDisassembler;
import com.impacto.algafood.api.assembler.PedidoModelAssembler;
import com.impacto.algafood.api.assembler.PedidoResumoModelAssembler;
import com.impacto.algafood.api.model.PedidoModel;
import com.impacto.algafood.api.model.PedidoResumoModel;
import com.impacto.algafood.api.model.input.PedidoInput;
import com.impacto.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.impacto.algafood.domain.exception.NegocioException;
import com.impacto.algafood.domain.model.Pedido;
import com.impacto.algafood.domain.model.Usuario;
import com.impacto.algafood.domain.repository.PedidoRepository;
import com.impacto.algafood.domain.service.EmissaoPedidoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private PedidoInputDisassembler pedidoInputDisassembler;

    @Autowired
    private PedidoResumoModelAssembler pedidoResumoModelAssembler;

    @GetMapping
    public MappingJacksonValue listar(@RequestParam (required = false) String campos) {
        List<PedidoResumoModel> pedidoResumoModels = pedidoResumoModelAssembler.toCollectionModel(pedidoRepository.findAll());

        MappingJacksonValue jacksonValue = new MappingJacksonValue(pedidoResumoModels);

        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("pedidosFilter", SimpleBeanPropertyFilter.serializeAll());

        if (StringUtils.isNoneBlank(campos)) {
            filterProvider.addFilter("pedidosFilter", SimpleBeanPropertyFilter.serializeAllExcept(campos.split(",")));
        }

        jacksonValue.setFilters(filterProvider);

        return jacksonValue;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoModel adicionar(@Valid @RequestBody PedidoInput pedidoInput) {
        try {
            Pedido novoPedido = pedidoInputDisassembler.toDomainObject(pedidoInput);

            novoPedido.setCliente(new Usuario());
            novoPedido.getCliente().setId(1L);

            novoPedido = emissaoPedido.emitir(novoPedido);

            return pedidoModelAssembler.toModel(novoPedido);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @GetMapping("{codigoPedido}")
    public PedidoModel buscar(@PathVariable Long codigoPedido) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
        return pedidoModelAssembler.toModel(pedido);
    }
}
