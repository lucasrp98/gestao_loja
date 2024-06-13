package br.com.api.biju.gestao_loja.modules.cliente.exceptions;

public class ClientExceptions {

    public static class UserFoundException extends RuntimeException {
        public UserFoundException() {
            super("Usuário já cadastrado");
        }
    }
}
