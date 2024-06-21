package br.com.api.biju.gestao_loja.modules.exceptions;

public class UserExceptions {
    public static class UserFoundException extends RuntimeException {
        public UserFoundException() {
            super("Usuário já cadastrado");
        }
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException() {
            super("Usuário não encontrado");
        }
    }

}
