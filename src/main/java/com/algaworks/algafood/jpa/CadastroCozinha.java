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

    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
        return em.merge(cozinha);
    }
}
