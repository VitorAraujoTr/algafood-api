package com.algaworks.algafood.service;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private final NotificadorEmail notificador;

    public AtivacaoClienteService(NotificadorEmail notificador) {
        this.notificador = notificador;

        System.out.println("AtivacaoClienteService: " + notificador);
    }
    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
