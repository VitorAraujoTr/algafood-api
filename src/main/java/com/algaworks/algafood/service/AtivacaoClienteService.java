package com.algaworks.algafood.service;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

//    Método simples de se injetar uma classe, porém, pode ser problemática
//      por conta do seu nível de acesso privado, do qual não será enxergada
//      principalmente em pelas classes de teste ou em uma configuração programática,
//      que precisaria de programar uma injeção.
    @Autowired
    private Notificador notificador;

//    O Spring consegue enxergar quem é o Autowired, pois assim, você consegue
//      apontar quem será o construtor principal da injeção.
//
//    O ideal seria este meio de injeção, direto no construtor, pois detalha
//      melhor o que está utilizando e passando, e também quando for montar
//      as classes de teste, por ser um método publico.
//
//    @Autowired
//    public AtivacaoClienteService(Notificador notificador) {
//        this.notificador = notificador;
//    }
//
//    public AtivacaoClienteService(String qualquer) {
//
//    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }

//    Este método de injeção também poderá funcionar.
//
//    @Autowired
//    public void setNotificador(Notificador notificador) {
//        this.notificador = notificador;
//    }
}
