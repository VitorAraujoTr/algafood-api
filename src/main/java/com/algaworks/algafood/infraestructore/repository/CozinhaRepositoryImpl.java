package com.algaworks.algafood.infraestructore.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cozinha> listar() {
        return em.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }

    @Override
    public Cozinha buscarPorId(Long id) {
        return em.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha adicionar(Cozinha cozinha) {
        return em.merge(cozinha);
    }

    @Transactional
    @Override
    public void remover(Long idCozinha) {

        Cozinha cozinha = buscarPorId(idCozinha);

        if (cozinha == null)
            throw new EmptyResultDataAccessException(1);

        em.remove(cozinha);
    }
}
