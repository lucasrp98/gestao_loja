package br.com.api.biju.gestao_loja.modules.cliente.exceptions;

public class ProdutoFoundException extends RuntimeException{

    public ProdutoFoundException(){
        super("Produto já cadastrado");
    }
}
