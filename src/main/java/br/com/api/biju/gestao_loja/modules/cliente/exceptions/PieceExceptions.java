package br.com.api.biju.gestao_loja.modules.cliente.exceptions;

public class PieceExceptions {


    public static class PecaFoundException extends RuntimeException {
        public PecaFoundException() {
            super("Peça já cadastrada");
        }
    }

    public static class PecaNotFoundException extends RuntimeException {
        public PecaNotFoundException() {
            super("Peça não cadastrada");
        }
    }

}
