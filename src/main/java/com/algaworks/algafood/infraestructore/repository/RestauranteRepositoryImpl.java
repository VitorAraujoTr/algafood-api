package com.algaworks.algafood.infraestructore.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Restaurante> todos() {
        return em.createQuery("from Restaurante", Restaurante.class)
                .getResultList();
    }

    @Override
    public Restaurante porId(Long id) {
        return em.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante adicionar(Restaurante restaurante) {
        return em.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Long idRestaurante) {

        Restaurante restaurante = porId(idRestaurante);

        if(restaurante == null)
            throw new EmptyResultDataAccessException(1);

        em.remove(restaurante);
    }
}
