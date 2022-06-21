package com.algaworks.algafoodapi.notificacao;

import com.algaworks.algafoodapi.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail {

    public NotificadorEmail() {
        System.out.println("Construtor e-mail chamado!");
    }

    public void notificar(Cliente cliente, String msg) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), msg);
    }
}
