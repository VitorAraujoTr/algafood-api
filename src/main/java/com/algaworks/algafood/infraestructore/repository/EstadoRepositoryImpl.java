package com.algaworks.algafood.infraestructore.repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public void remover(Estado estado) {

        estado = buscarPorId(estado.getId());

        em.remove(estado);
    }
}
