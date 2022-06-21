package com.algaworks.algafoodapi.service;

import com.algaworks.algafoodapi.modelo.Cliente;
import com.algaworks.algafoodapi.notificacao.NotificadorEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtivacaoClienteService {

    private final NotificadorEmail notificador;
    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
