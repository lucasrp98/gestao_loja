package br.com.api.biju.gestao_loja.modules.exceptions;

public class PaymentMethodExceptions {

    public static class PaymentMethodException extends RuntimeException {
        public PaymentMethodException() {
            super("Forma de pagamento já cadastrada");
        }
    }

    public static class PaymentMethodNotFoundException extends RuntimeException {
        public PaymentMethodNotFoundException() {
            super("Forma de pagamento não encontrada");
        }
    }
}
