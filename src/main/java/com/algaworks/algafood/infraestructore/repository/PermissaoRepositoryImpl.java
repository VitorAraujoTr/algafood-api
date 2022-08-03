package com.algaworks.algafood.infraestructore.repository;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Permissao> listar() {
        return em.createQuery("from Permissao", Permissao.class)
                .getResultList();
    }

    @Override
    public Permissao buscarPorId(Long id) {
        return em.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public Permissao adicionar(Permissao permissao) {
        return em.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {

        permissao = buscarPorId(permissao.getId());

        em.remove(permissao);
    }
}
