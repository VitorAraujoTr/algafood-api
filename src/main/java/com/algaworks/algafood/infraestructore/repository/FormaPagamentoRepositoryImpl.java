package com.algaworks.algafood.infraestructore.repository;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<FormaPagamento> listar() {
        return em.createQuery("from FormaPagamento", FormaPagamento.class)
                .getResultList();
    }

    @Override
    public FormaPagamento buscarPorId(Long id) {
        return em.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public FormaPagamento adicionar(FormaPagamento formaPagamento) {
        return em.merge(formaPagamento);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento formaPagamento) {

        formaPagamento = buscarPorId(formaPagamento.getId());

        em.remove(formaPagamento);
    }
}
