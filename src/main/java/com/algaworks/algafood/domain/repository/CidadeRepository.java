package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();
    Cidade buscarPorId(Long id);
    Cidade adicionar(Cidade cidade);
    void remover(Long idCidade);

}
