package fruit.shop.service;

public class TransactionInputValidationException extends RuntimeException {
    public TransactionInputValidationException(String message) {
        super(message);
    }
}
