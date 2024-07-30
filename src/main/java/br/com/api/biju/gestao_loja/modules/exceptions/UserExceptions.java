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

    public static class TypeUserFoundException extends RuntimeException {
        public TypeUserFoundException() {
            super("Tipo de usuário já cadastrado");
        }
    }

    public static class TypeUserNotFoundException extends RuntimeException {
        public TypeUserNotFoundException() {
            super("Tipo de usuário não cadastrado cadastrado");
        }
    }


}
