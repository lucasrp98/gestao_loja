package br.com.api.biju.gestao_loja.modules.exceptions;

public class SaleExceptions {

    public static class SellerFoundException extends RuntimeException {
        public SellerFoundException() {
            super("Venda já cadastrado");
        }
    }

}
