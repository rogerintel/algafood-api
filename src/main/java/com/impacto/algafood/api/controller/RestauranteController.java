package com.impacto.algafood.api.controller;

import com.impacto.algafood.api.model.CozinhaModel;
import com.impacto.algafood.api.model.RestauranteModel;
import com.impacto.algafood.api.model.input.RestauranteInput;
import com.impacto.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.impacto.algafood.domain.exception.NegocioException;
import com.impacto.algafood.domain.model.Restaurante;
import com.impacto.algafood.domain.repository.RestauranteRepository;
import com.impacto.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @GetMapping
    public List<RestauranteModel> listar() {
        return toCollectionModel(restauranteRepository.findAll());
    }

    @GetMapping("/{restauranteId}")
    public RestauranteModel buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return toModel(restaurante);
    }

    private RestauranteModel toModel(Restaurante restaurante) {
        CozinhaModel cozinhaModel = new CozinhaModel(restaurante.getCozinha().getId(), restaurante.getCozinha().getNome());
        return new RestauranteModel(restaurante.getId(), restaurante.getNome(), restaurante.getTaxaFrete(), cozinhaModel);
    }

    private List<RestauranteModel> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteModel adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {
        try {
            Restaurante restaurante = toEntity(restauranteInput);
            return toModel(cadastroRestaurante.salvar(restaurante));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    private Restaurante toEntity(RestauranteInput restauranteInput) {
        return new Restaurante(restauranteInput.getNome(), restauranteInput.getTaxaFrete(),
                new CozinhaModel(restauranteInput.getCozinha().getId()));
    }

    @PutMapping("/{restauranteId}")
    public RestauranteModel atualizar(@PathVariable Long restauranteId,
                                 @RequestBody @Valid Restaurante restaurante) {

        try {
            Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);

            BeanUtils.copyProperties(restaurante, restauranteAtual,
                    "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

            return toModel(cadastroRestaurante.salvar(restauranteAtual));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }


}
