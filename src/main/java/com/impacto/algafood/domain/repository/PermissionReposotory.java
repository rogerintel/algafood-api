package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionReposotory extends JpaRepository<Permissao, Long> {
}
