package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroCozinhaService {

    private final CozinhaRepository cozinhas;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhas.adicionar(cozinha);
    }



}
