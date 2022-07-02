package com.impacto.algafood.domain.repository;

import com.impacto.algafood.domain.model.Permission;

import java.util.List;

public interface PermissionReposotory {
    List<Permission> getAll();
    Permission getById(Long id);
    Permission save(Permission permission);
    void delete(Long id);
}
