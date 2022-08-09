package com.algaworks.algafood.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1711889863782746963L;

    public EntidadeNaoEncontradaException(String msg) {
        super(msg);
    }
}
