package com.algaworks.algafoodapi.service;

import com.algaworks.algafoodapi.modelo.Cliente;
import com.algaworks.algafoodapi.modelo.Produto;
import com.algaworks.algafoodapi.notificacao.Notificador;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmissaoNotaFiscalService {

    private final Notificador notificador;

    public void emitir(Cliente cliente, Produto produto) {
        notificador.notificar(cliente, "Nota fiscal do produto "
                + produto.getNome() + "foi emitida!");
    }
}
