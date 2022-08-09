package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroRestauranteService {

    private final RestauranteRepository restauranteRepository;

    private final CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long idCozinha = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.buscarPorId(idCozinha);

        if(cozinha == null)
            throw new EntidadeNaoEncontradaException(
                    String.format("Cozinha com código %d não existente", idCozinha));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.adicionar(restaurante);
    }

    public void excluir(Long idRestaurante) {
        try {
            restauranteRepository.remover(idRestaurante);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de Restaurante com código %d.", idRestaurante));
        }


    }


}
