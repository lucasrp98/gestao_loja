package br.com.api.biju.gestao_loja.modules.cliente.exceptions;

public class PecaFoundException extends RuntimeException {
    public PecaFoundException() {
        super("Peça já cadastrada");
    }

}
