package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroCidadeService {

    public final CidadeRepository cidadeRepository;

    public final EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.adicionar(cidade);
    }

    public Cidade atualizar(Cidade cidade) {
        Long idEstado = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscarPorId(idEstado);

        if (estado == null)
            throw new EntidadeNaoEncontradaException(
                    String.format("Estado com código %d não existente", idEstado));

        cidade.setEstado(estado);

        return cidadeRepository.adicionar(cidade);
    }

    public void excluir(Long idCidade) {
        try {
            cidadeRepository.remover(idCidade);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de Cidade com código %d.", idCidade));
        }
    }
}
