package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroEstadoService {

    private final EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.adicionar(estado);
    }

    public void excluir(Long idEstado) {
        try {
            estadoRepository.remover(idEstado);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de Estado com código %d.", idEstado));
        } catch (DataIntegrityViolationException e) {
           throw new EntidadeEmUsoException(
                   String.format("Estado de código %d não pode ser removida, pois está em uso.", idEstado));
        }

    }
}
