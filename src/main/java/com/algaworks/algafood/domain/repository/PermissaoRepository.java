package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();
    Permissao buscarPorId(Long id);
    Permissao adicionar(Permissao permissao);
    void remover(Permissao permissao);

}
