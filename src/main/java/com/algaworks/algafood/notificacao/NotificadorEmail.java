package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.modelo.Cliente;

public class NotificadorEmail implements Notificador{

    private boolean caixaAlta;
    private final String hostServidorSmtp;

    public NotificadorEmail(String hostServidorSmtp) {
        this.hostServidorSmtp = hostServidorSmtp;
        System.out.println("Construtor e-mail chamado!");
    }

    public void notificar(Cliente cliente, String msg) {

        try {
            if (this.caixaAlta)
                msg = msg.toUpperCase();

            System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n",
                    cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, msg);

        } catch (NullPointerException e) {
            System.out.println("Mensagem inválida!");
        }
    }

    public void setCaixaAlta(boolean caixaAlta) {
        this.caixaAlta = caixaAlta;
    }
}
