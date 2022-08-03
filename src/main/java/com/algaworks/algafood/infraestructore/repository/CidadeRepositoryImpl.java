package com.algaworks.algafood.infraestructore.repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cidade> listar() {
        return em.createQuery("from Cidade", Cidade.class)
                .getResultList();
    }

    @Override
    public Cidade buscarPorId(Long id) {
        return em.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade adicionar(Cidade cidade) {
        return em.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Cidade cidade) {

        cidade = buscarPorId(cidade.getId());

        em.remove(cidade);
    }
}
