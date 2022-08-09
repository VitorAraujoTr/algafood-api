package com.algaworks.algafood.infraestructore.repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Estado> listar() {
        return em.createQuery("from Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado buscarPorId(Long id) {
        return em.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado adicionar(Estado estado) {
        return em.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Estado estado = buscarPorId(id);

        if(estado == null)
            throw new EmptyResultDataAccessException(1);

        em.remove(estado);
    }
}
