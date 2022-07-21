package com.algaworks.algafood.jpa;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager em;

    public List<Cozinha> listar() {
        return em.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }

    public Cozinha buscar(Long id) {
        return em.find(Cozinha.class, id);
    }

    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return em.merge(cozinha);
    }

    @Transactional
    public void remover(Cozinha cozinha) {

        cozinha = buscar(cozinha.getId());

        em.remove(cozinha);
    }
}
