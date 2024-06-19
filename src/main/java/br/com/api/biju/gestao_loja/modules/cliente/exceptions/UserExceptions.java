package br.com.api.biju.gestao_loja.modules.cliente.exceptions;

public class UserExceptions {
    public static class UserFoundException extends RuntimeException {
        public UserFoundException() {
            super("Usuário já cadastrado");
        }
    }
}
