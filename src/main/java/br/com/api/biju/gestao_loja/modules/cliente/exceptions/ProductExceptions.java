package br.com.api.biju.gestao_loja.modules.cliente.exceptions;

public class ProductExceptions {

    public static class ProdutoFoundException extends RuntimeException {
        public ProdutoFoundException() {
            super("Produto já cadastrado");
        }
    }
}
