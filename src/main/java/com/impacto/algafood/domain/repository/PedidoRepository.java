package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long> {
}
