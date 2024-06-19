package br.com.api.biju.gestao_loja.modules.cliente.exceptions;

public class ClientExceptions {

    public static class ClientFoundException extends RuntimeException {
        public ClientFoundException() {
            super("Cliente já cadastrado");
        }
    }
}
