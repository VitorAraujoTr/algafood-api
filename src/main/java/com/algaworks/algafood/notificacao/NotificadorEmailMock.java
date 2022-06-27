package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador{

    public NotificadorEmailMock() {
        System.out.println("NotificadorEmail Mock");
    }

    public void notificar(Cliente cliente, String msg) {
        System.out.printf("Mock: Notificação seria enviada para %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), msg);
    }
}
