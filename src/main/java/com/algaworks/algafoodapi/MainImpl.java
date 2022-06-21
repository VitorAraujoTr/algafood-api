package com.algaworks.algafoodapi;

import com.algaworks.algafoodapi.modelo.Cliente;
import com.algaworks.algafoodapi.notificacao.NotificadorEmail;
import com.algaworks.algafoodapi.notificacao.NotificadorSMS;
import com.algaworks.algafoodapi.service.AtivacaoClienteService;

public class MainImpl implements Main {

    @Override
    public void main() {
        Cliente joao = new Cliente("João", "joao@xyz.com", "61999999999");
        Cliente maria = new Cliente("Maria", "maria@xyz.com", "61988888888");

        AtivacaoClienteService ativacaoClienteSMS = new AtivacaoClienteService(new NotificadorSMS());
        ativacaoClienteSMS.ativar(joao);
        ativacaoClienteSMS.ativar(maria);

        AtivacaoClienteService ativacaoClienteEmail = new AtivacaoClienteService(new NotificadorEmail());
        ativacaoClienteEmail.ativar(joao);
        ativacaoClienteEmail.ativar(maria);
    }
}
