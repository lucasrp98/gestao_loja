package br.com.api.biju.gestao_loja.modules.exceptions;

public class ProductExceptions {

    public static class ProdutoFoundException extends RuntimeException {
        public ProdutoFoundException() {
            super("Produto já cadastrado");
        }
    }

    public static class TypeProductFoundException extends RuntimeException {
        public TypeProductFoundException() {
            super("Tipo de produto já cadastrado");
        }
    }
}
